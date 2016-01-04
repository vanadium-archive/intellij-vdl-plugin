// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.RecursionManager;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;
import com.intellij.psi.SmartPsiElementPointer;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceOwner;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.PsiFileReference;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.GlobalSearchScopesCore;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.psi.util.PsiModificationTracker;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ObjectUtils;
import com.intellij.util.containers.ContainerUtil;
import io.v.vdl.VdlStringLiteralEscaper;
import io.v.vdl.psi.impl.VdlStringLiteralImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VdlPsiImplUtil {
    public static final Key<SmartPsiElementPointer<VdlReferenceExpressionBase>> CONTEXT = Key.create("CONTEXT");

    @NotNull
    public static VdlStringLiteralEscaper createLiteralTextEscaper(@NotNull VdlStringLiteral o) {
        return new VdlStringLiteralEscaper(o);
    }

    @NotNull
    public static VdlStringLiteral updateText(@NotNull VdlStringLiteral o, @NotNull String text) {
        if (text.length() > 2) {
            if (o.getString() != null) {
                StringBuilder outChars = new StringBuilder();
                VdlStringLiteralEscaper.escapeString(text.substring(1, text.length()-1), outChars);
                outChars.insert(0, '"');
                outChars.append('"');
                text = outChars.toString();
            }
        }

        ASTNode valueNode = o.getNode().getFirstChildNode();
        assert valueNode instanceof LeafElement;

        ((LeafElement)valueNode).replaceWithText(text);
        return o;
    }

    public static boolean isValidHost(@SuppressWarnings("UnusedParameters") @NotNull VdlStringLiteral o) {
        return true;
    }

    public static boolean shouldGoDeeper(@SuppressWarnings("UnusedParameters")  @NotNull VdlTypeSpec o) {
        return false;
    }

    @Nullable
    public static String getName(@NotNull VdlPackageClause packageClause) {
        PsiElement packageIdentifier = packageClause.getIdentifier();
        if (packageIdentifier != null) {
            return packageIdentifier.getText().trim();
        }
        return null;
    }

    public static int getArity(@Nullable VdlSignature s) {
        return s == null ? -1 : s.getParameters().getParameterDeclarationList().size();
    }

    public static boolean isDot(@NotNull VdlImportSpec importSpec) {
        VdlImportSpecStub stub = importSpec.getStub();
        return stub != null ? stub.isDot() : importSpec.getDot() != null;
    }

    @NotNull
    public static String getPath(@NotNull VdlImportSpec importSpec) {
        VdlImportSpecStub stub = importSpec.getStub();
        return stub != null ? stub.getPath() : importSpec.getImportString().getPath();
    }

    @NotNull
    public static String getPath(@NotNull VdlImportString o) {
        return unquote(o.getText());
    }

    @NotNull
    public static String unquote(@Nullable String s) {
        if (StringUtil.isEmpty(s)) return "";
        char quote = s.charAt(0);
        int startOffset = isQuote(quote) ? 1 : 0;
        int endOffset = s.length();
        if (s.length() > 1) {
            char lastChar = s.charAt(s.length() - 1);
            if (isQuote(quote) && lastChar == quote) {
                endOffset = s.length() - 1;
            }
            if (!isQuote(quote) && isQuote(lastChar)){
                endOffset = s.length() - 1;
            }
        }
        return s.substring(startOffset, endOffset);
    }

    private static boolean isQuote(char ch) {
        return ch == '"' || ch == '\'' || ch == '`';
    }

    public static String getAlias(@NotNull VdlImportSpec importSpec) {
        VdlImportSpecStub stub = importSpec.getStub();
        if (stub != null) {
            return stub.getAlias();
        }

        PsiElement identifier = importSpec.getIdentifier();
        if (identifier != null) {
            return identifier.getText();
        }
        return importSpec.isDot() ? "." : null;
    }

    public static String getName(@NotNull VdlImportSpec importSpec) {
        return getAlias(importSpec);
    }

    public static VdlTypeReferenceExpression getTypeReference(VdlType type) {
        if (type == null) return null;
        if (type instanceof VdlReceiverType) {
            return PsiTreeUtil.findChildOfAnyType(type, VdlTypeReferenceExpression.class);
        }
        return type.getTypeReferenceExpression();
    }

    @NotNull
    public static PsiReference getReference(@NotNull VdlTypeReferenceExpression o) {
        return new VdlTypeReference(o);
    }

    @Nullable
    public static PsiDirectory resolve(@NotNull VdlImportString importString) {
        PsiReference[] references = importString.getReferences();
        for (PsiReference reference : references) {
            if (reference instanceof FileReferenceOwner) {
                PsiFileReference lastFileReference = ((FileReferenceOwner)reference).getLastFileReference();
                PsiElement result = lastFileReference != null ? lastFileReference.resolve() : null;
                return result instanceof PsiDirectory ? (PsiDirectory)result : null;
            }
        }
        return null;
    }

    @Nullable
    public static VdlType getGoType(@NotNull final VdlExpression o, @Nullable final ResolveState context) {
        return RecursionManager.doPreventingRecursion(o, true, new Computable<VdlType>() {
            @Override
            public VdlType compute() {
                if (context != null) return getVdlTypeInner(o, context);
                return CachedValuesManager.getCachedValue(o, new CachedValueProvider<VdlType>() {
                    @Nullable
                    @Override
                    public Result<VdlType> compute() {
                        return Result.create(getVdlTypeInner(o, null), PsiModificationTracker.MODIFICATION_COUNT);
                    }
                });
            }
        });
    }

    @Nullable
    public static VdlType getVdlTypeInner(@NotNull final VdlExpression o, @Nullable ResolveState context) {
        if (o instanceof VdlUnaryExpr) {
            VdlExpression expression = ((VdlUnaryExpr)o).getExpression();
            if (expression != null) {
                VdlType type = expression.getVdlType(context);
                if (type instanceof VdlChannelType && ((VdlUnaryExpr)o).getSendChannel() != null) return ((VdlChannelType)type).getType();
                if (type instanceof VdlPointerType && ((VdlUnaryExpr)o).getMul() != null) return ((VdlPointerType)type).getType();
                return type;
            }
            return null;
        }
        else if (o instanceof VdlAddExpr) {
            return ((VdlAddExpr)o).getLeft().getVdlType(context);
        }
        else if (o instanceof VdlMulExpr) {
            VdlExpression left = ((VdlMulExpr)o).getLeft();
            if (!(left instanceof VdlLiteral)) return left.getVdlType(context);
            VdlExpression right = ((VdlBinaryExpr)o).getRight();
            if (right != null) return right.getVdlType(context);
        }
        else if (o instanceof VdlCompositeLit) {
            VdlType type = ((VdlCompositeLit)o).getType();
            if (type != null) return type;
            VdlTypeReferenceExpression expression = ((VdlCompositeLit)o).getTypeReferenceExpression();
            return findTypeFromTypeRef(expression);
        }
        else if (o instanceof VdlCallExpr) {
            VdlExpression e = ((VdlCallExpr)o).getExpression();
            VdlType type = ((VdlCallExpr)o).getExpression().getVdlType(context);
            if (type instanceof VdlFunctionType) {
                return funcType(type);
            }
            VdlType byRef = type == null ? null : findBaseTypeFromRef(type.getTypeReferenceExpression());
            if (byRef instanceof VdlSpecType && ((VdlSpecType)byRef).getType() instanceof VdlFunctionType) {
                return funcType(((VdlSpecType)byRef).getType());
            }
            return type;
        }
        else if (o instanceof VdlReferenceExpression) {
            PsiReference reference = o.getReference();
            PsiElement resolve = reference != null ? reference.resolve() : null;
            if (resolve instanceof VdlTypeOwner) return typeOrParameterType((VdlTypeOwner)resolve, context);
        }
        else if (o instanceof VdlParenthesesExpr) {
            VdlExpression expression = ((VdlParenthesesExpr)o).getExpression();
            return expression != null ? expression.getVdlType(context) : null;
        }
        else if (o instanceof VdlSelectorExpr) {
            VdlExpression item = ContainerUtil.getLastItem(((VdlSelectorExpr)o).getExpressionList());
            return item != null ? item.getVdlType(context) : null;
        }
        else if (o instanceof VdlIndexOrSliceExpr) {
            VdlExpression first = ContainerUtil.getFirstItem(((VdlIndexOrSliceExpr)o).getExpressionList());
            VdlType type = first == null ? null : first.getVdlType(context);
            if (o.getNode().findChildByType(VdlTypes.COLON) != null) return type; // means slice expression, todo: extract if needed
            VdlTypeReferenceExpression typeRef = getTypeReference(type);
            if (typeRef != null) {
                type = findTypeFromTypeRef(typeRef);
            }
            if (type instanceof VdlSpecType) type = ((VdlSpecType)type).getType();
            else if (type instanceof VdlSetType) {
                type = ((VdlSetType)type).getType();
            }
            else if (type instanceof VdlArrayOrSliceType) {
                VdlType tt = ((VdlArrayOrSliceType)type).getType();
                return typeFromRefOrType(tt);
            }
            if (type instanceof VdlMapType) {
                List<VdlType> list = ((VdlMapType)type).getTypeList();
                if (list.size() == 2) {
                    return list.get(1);
                }
            }
        }
        else if (o instanceof VdlTypeAssertionExpr) {
            return ((VdlTypeAssertionExpr)o).getType();
        }
        else if (o instanceof VdlConversionExpr) {
            return ((VdlConversionExpr)o).getType();
        }
        else if (o instanceof VdlStringLiteral) {
            return getBuiltinType(o, "string");
        }
        else if (o instanceof VdlLiteral) {
            VdlLiteral l = (VdlLiteral)o;
            if (l.getChar() != null) return getBuiltinType(o, "rune");
            if (l.getInt() != null || l.getHex() != null || ((VdlLiteral)o).getOct() != null) return getBuiltinType(o, "int");
            if (l.getFloat() != null) return getBuiltinType(o, "float64");
            if (l.getFloati() != null) return getBuiltinType(o, "complex64");
            if (l.getDecimali() != null) return getBuiltinType(o, "complex128");
        }
        return null;
    }

    @Nullable
    private static VdlType getBuiltinType(@NotNull VdlExpression o, @NotNull final String name) {
        // TODO(sjr): handle VDL builtin types
        return null;
    }

    @Nullable
    private static VdlType findTypeFromTypeRef(@Nullable VdlTypeReferenceExpression expression) {
        PsiReference reference = expression != null ? expression.getReference() : null;
        PsiElement resolve = reference != null ? reference.resolve() : null;
        if (resolve instanceof VdlTypeSpec) return ((VdlTypeSpec)resolve).getSpecType();
        return null;
    }

    @Nullable
    private static VdlType typeFromRefOrType(@Nullable VdlType t) {
        if (t == null) return null;
        VdlTypeReferenceExpression tr = getTypeReference(t);
        return tr != null ? findTypeFromTypeRef(tr) : t;
    }

    @Nullable
    public static VdlType typeOrParameterType(@NotNull final VdlTypeOwner resolve, @Nullable ResolveState context) {
        VdlType type = resolve.getVdlType(context);
        if (resolve instanceof VdlParamDefinition && ((VdlParamDefinition)resolve).isVariadic()) {
            return type == null ? null : new VdlLightType.MyArrayType(type);
        }
        if (resolve instanceof VdlNamedSignatureOwner) {
            return new VdlLightType.MyFunctionType((VdlNamedSignatureOwner)resolve);
        }
        return type;
    }

    public static boolean isVariadic(@NotNull VdlParameterDeclaration o) {
        return o.getTripleDot() != null;
    }

    public static boolean isVariadic(@NotNull VdlParamDefinition o) {
        PsiElement parent = o.getParent();
        return parent instanceof VdlParameterDeclaration && ((VdlParameterDeclaration)parent).isVariadic();
    }

    /**
     * Finds the "base" type of {@code expression}, resolving type references iteratively until a type spec is found.
     */
    @Nullable
    public static VdlType findBaseTypeFromRef(@Nullable VdlTypeReferenceExpression expression) {
        return findBaseSpecType(findTypeFromTypeRef(expression));
    }

    @Nullable
    public static VdlType findBaseSpecType(@Nullable VdlType type) {
        while (type instanceof VdlSpecType && ((VdlSpecType)type).getType().getTypeReferenceExpression() != null) {
            VdlType inner = findTypeFromTypeRef(((VdlSpecType)type).getType().getTypeReferenceExpression());
            if (inner == null || type.isEquivalentTo(inner)) return type;
            type = inner;
        }
        return type;
    }

    @Nullable
    private static VdlType funcType(@Nullable VdlType type) {
        if (type instanceof VdlFunctionType) {
            VdlSignature signature = ((VdlFunctionType)type).getSignature();
            VdlResult result = signature != null ? signature.getResult() : null;
            if (result != null) {
                VdlType rt = result.getType();
                if (rt != null) return rt;
                VdlResultParameters parameters = result.getResultParameters();
                if (parameters != null) {
                    List<VdlParameterDeclaration> list = parameters.getParameterDeclarationList();
                    List<VdlType> types = ContainerUtil.newArrayListWithCapacity(list.size());
                    for (VdlParameterDeclaration declaration : list) {
                        VdlType declarationType = declaration.getType();
                        for (VdlParamDefinition ignored : declaration.getParamDefinitionList()) {
                            types.add(declarationType);
                        }
                    }
                    if (types.size() == 1) return types.get(0);
                    return new VdlLightType.MyVdlTypeList(parameters, types);
                }
            }
        }
        return type;
    }

    @Nullable
    public static VdlReferenceExpression getQualifier(@NotNull VdlReferenceExpression o) {
        return PsiTreeUtil.getChildOfType(o, VdlReferenceExpression.class);
    }

    @Nullable
    public static VdlTypeReferenceExpression getQualifier(@NotNull VdlTypeReferenceExpression o) {
        return PsiTreeUtil.getChildOfType(o, VdlTypeReferenceExpression.class);
    }

    @Nullable
    static PsiFile getContextFile(@NotNull ResolveState state) {
        SmartPsiElementPointer<VdlReferenceExpressionBase> context = state.get(CONTEXT);
        return context != null ? context.getContainingFile() : null;
    }

    @Nullable
    public static VdlTypeSpec getTypeSpecSafe(@NotNull VdlType type) {
        VdlTypeStub stub = type.getStub();
        PsiElement parent = stub == null ? type.getParent() : stub.getParentStub().getPsi();
        return ObjectUtils.tryCast(parent, VdlTypeSpec.class);
    }

    @NotNull
    public static List<VdlMethodSpec> getMethods(@NotNull VdlInterfaceType o) {
        return ContainerUtil.filter(o.getMethodSpecList(), new Condition<VdlMethodSpec>() {
            @Override
            public boolean value(@NotNull VdlMethodSpec spec) {
                return spec.getIdentifier() != null;
            }
        });
    }

    @NotNull
    public static List<VdlTypeReferenceExpression> getBaseTypesReferences(@NotNull VdlInterfaceType o) {
        final List<VdlTypeReferenceExpression> refs = ContainerUtil.newArrayList();
        o.accept(new VdlRecursiveVisitor() {
            @Override
            public void visitMethodSpec(@NotNull VdlMethodSpec o) {
                ContainerUtil.addIfNotNull(refs, o.getTypeReferenceExpression());
            }
        });
        return refs;
    }

    static boolean processNamedElements(@NotNull PsiScopeProcessor processor,
                                        @NotNull ResolveState state,
                                        @NotNull Collection<? extends VdlNamedElement> elements,
                                        boolean localResolve) {
        return processNamedElements(processor, state, elements, localResolve, false);
    }

    static boolean processNamedElements(@NotNull PsiScopeProcessor processor,
                                        @NotNull ResolveState state,
                                        @NotNull Collection<? extends VdlNamedElement> elements,
                                        boolean localResolve,
                                        boolean checkContainingFile) {
        PsiFile contextFile = checkContainingFile ? getContextFile(state) : null;
        for (VdlNamedElement definition : elements) {
            if (!definition.isValid() || checkContainingFile) continue;
            if ((localResolve || definition.isPublic()) && !processor.execute(definition, state)) return false;
        }
        return true;
    }

    public static boolean prevDot(@Nullable PsiElement e) {
        PsiElement prev = e == null ? null : PsiTreeUtil.prevVisibleLeaf(e);
        return prev instanceof LeafElement && ((LeafElement)prev).getElementType() == VdlTypes.DOT;
    }

    public static String getLocalPackageName(@NotNull VdlImportSpec importSpec) {
        return getLocalPackageName(importSpec.getPath());
    }

    public static String getLocalPackageName(@NotNull String importPath) {
        StringBuilder name = null;
        for (int i = 0; i < importPath.length(); i++) {
            char c = importPath.charAt(i);
            if (!(Character.isLetter(c) || c == '_' || (i != 0 && Character.isDigit(c)))) {
                if (name == null) {
                    name = new StringBuilder(importPath.length());
                    name.append(importPath, 0, i);
                }
                name.append('_');
            }
            else if (name != null) {
                name.append(c);
            }
        }
        return name == null ? importPath : name.toString();
    }

    @Nullable
    public static VdlType getVdlType(@NotNull final VdlExpression o, @Nullable final ResolveState context) {
        return RecursionManager.doPreventingRecursion(o, true, new Computable<VdlType>() {
            @Override
            public VdlType compute() {
                if (context != null) return getVdlTypeInner(o, context);
                return CachedValuesManager.getCachedValue(o, new CachedValueProvider<VdlType>() {
                    @Nullable
                    @Override
                    public Result<VdlType> compute() {
                        return Result.create(getVdlTypeInner(o, null), PsiModificationTracker.MODIFICATION_COUNT);
                    }
                });
            }
        });
    }

    @Nullable
    public static VdlReferenceExpression getQualifier(@SuppressWarnings("UnusedParameters") @NotNull VdlFieldName o) {
        return null;
    }

    @Nullable
    public static PsiElement getIdentifier(@SuppressWarnings("UnusedParameters") @NotNull VdlAnonymousFieldDefinition o) {
        return null;
    }
}
