package io.v.vdl.psi;

import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.RecursionManager;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiPolyVariantReferenceBase;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.ResolveState;
import com.intellij.psi.SmartPointerManager;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.ObjectUtils;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.OrderedSet;
import io.v.vdl.VdlUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class VdlReference extends PsiPolyVariantReferenceBase<VdlReferenceExpressionBase> {
    public static final Key<List<? extends PsiElement>> IMPORT_USERS = Key.create("IMPORT_USERS");
    public static final Key<String> ACTUAL_NAME = Key.create("ACTUAL_NAME");
    public static final Key<Object> POINTER = Key.create("POINTER");
    public static final Key<Object> DONT_PROCESS_METHODS = Key.create("DONT_PROCESS_METHODS");

    private static final ResolveCache.PolyVariantResolver<PsiPolyVariantReferenceBase> MY_RESOLVER =
            new ResolveCache.PolyVariantResolver<PsiPolyVariantReferenceBase>() {
                @NotNull
                @Override
                public ResolveResult[] resolve(@NotNull PsiPolyVariantReferenceBase psiPolyVariantReferenceBase, boolean incompleteCode) {
                    return ((VdlReference)psiPolyVariantReferenceBase).resolveInner();
                }
            };

    public VdlReference(@NotNull VdlReferenceExpressionBase o) {
        super(o, TextRange.from(o.getIdentifier().getStartOffsetInParent(), o.getIdentifier().getTextLength()));
    }

    @NotNull
    private ResolveResult[] resolveInner() {
        if (!myElement.isValid()) return ResolveResult.EMPTY_ARRAY;
        Collection<ResolveResult> result = new OrderedSet<ResolveResult>();
        processResolveVariants(createResolveProcessor(result, myElement));
        return result.toArray(new ResolveResult[result.size()]);
    }

    @Override
    public boolean isReferenceTo(@NotNull PsiElement element) {
        return VdlUtil.couldBeReferenceTo(element, myElement) && super.isReferenceTo(element);
    }

    @NotNull
    private PsiElement getIdentifier() {
        return myElement.getIdentifier();
    }

    @NotNull
    static VdlScopeProcessor createResolveProcessor(@NotNull final Collection<ResolveResult> result, @NotNull final VdlReferenceExpressionBase o) {
        return new VdlScopeProcessor() {
            @Override
            public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
                if (element.equals(o)) return !result.add(new PsiElementResolveResult(element));
                String name = ObjectUtils.chooseNotNull(state.get(ACTUAL_NAME),
                        element instanceof PsiNamedElement ? ((PsiNamedElement)element).getName() : null);
                if (name != null && o.getIdentifier().textMatches(name)) {
                    result.add(new PsiElementResolveResult(element));
                    return false;
                }
                return true;
            }
        };
    }

    @Override
    @NotNull
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        if (!myElement.isValid()) return ResolveResult.EMPTY_ARRAY;
        return ResolveCache.getInstance(myElement.getProject()).resolveWithCaching(this, MY_RESOLVER, false, false);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    public boolean processResolveVariants(@NotNull VdlScopeProcessor processor) {
        PsiFile file = myElement.getContainingFile();
        if (!(file instanceof VdlFile)) return false;
        ResolveState state = createContext();
        VdlReferenceExpressionBase qualifier = myElement.getQualifier();
        return qualifier != null
                ? processQualifierExpression(((VdlFile)file), qualifier, processor, state)
                : processUnqualifiedResolve(((VdlFile)file), processor, state);
    }

    private boolean processQualifierExpression(@NotNull VdlFile file,
                                               @NotNull VdlReferenceExpressionBase qualifier,
                                               @NotNull VdlScopeProcessor processor,
                                               @NotNull ResolveState state) {
        PsiReference reference = qualifier.getReference();
        PsiElement target = reference != null ? reference.resolve() : null;
        if (target == null) return false;
        if (target == qualifier) return processor.execute(myElement, state);
        if (target instanceof VdlImportSpec) {
            target = ((VdlImportSpec)target).getImportString().resolve();
        }
        if (target instanceof PsiDirectory && !processDirectory((PsiDirectory)target, file, null, processor, state, false)) return false;
        if (target instanceof VdlTypeOwner) {
            VdlType type = VdlPsiImplUtil.typeOrParameterType((VdlTypeOwner)target, createContext());
            if (type != null) {
                if (!processGoType(type, processor, state)) return false;
                VdlTypeReferenceExpression ref = getTypeRefExpression(type);
                if (ref != null && ref.getReference().resolve() == ref) return processor.execute(myElement, state); // a bit hacky resolve for: var a C.foo; a.b
            }
        }
        return true;
    }

    @Nullable
    private static VdlTypeReferenceExpression getTypeRefExpression(@NotNull VdlType type) {
        if (type instanceof VdlPointerType) {
            VdlType inner = ((VdlPointerType)type).getType();
            return inner == null ? null : inner.getTypeReferenceExpression();
        }
        return type.getTypeReferenceExpression();
    }

    private boolean processGoType(@NotNull final VdlType type, @NotNull final VdlScopeProcessor processor, final @NotNull ResolveState state) {
        Boolean result = RecursionManager.doPreventingRecursion(type, true, new Computable<Boolean>() {
            @Override
            public Boolean compute() {
                if (type instanceof VdlParType) return processGoType(((VdlParType)type).getType(), processor, state);
                if (!processExistingType(type, processor, state)) return false;
                if (type instanceof VdlPointerType) {
                    if (!processPointer((VdlPointerType)type, processor, state.put(POINTER, true))) return false;
                    VdlType pointer = ((VdlPointerType)type).getType();
                    if (pointer instanceof VdlPointerType) {
                        return processPointer((VdlPointerType)pointer, processor, state.put(POINTER, true));
                    }
                }
                return processTypeRef(type, processor, state);
            }
        });
        return result != null && result;
    }

    private boolean processPointer(@NotNull VdlPointerType type, @NotNull VdlScopeProcessor processor, @NotNull ResolveState state) {
        VdlType pointer = type.getType();
        return pointer == null || processExistingType(pointer, processor, state) && processTypeRef(pointer, processor, state);
    }

    private boolean processTypeRef(@Nullable VdlType type, @NotNull VdlScopeProcessor processor, @NotNull ResolveState state) {
        return type == null || processInTypeRef(VdlPsiImplUtil.getTypeReference(type), processor, state);
    }

    private boolean processExistingType(@NotNull VdlType type,
                                        @NotNull VdlScopeProcessor processor,
                                        @NotNull ResolveState state) {
        PsiFile file = type.getContainingFile();
        if (!(file instanceof VdlFile)) return true;
        PsiFile myFile = ObjectUtils.notNull(VdlPsiImplUtil.getContextFile(state), myElement.getContainingFile());
        if (!(myFile instanceof VdlFile)) return true;

        boolean localResolve = isLocalResolve(myFile, file);

        if (type instanceof VdlSpecType) {
            VdlType theLatestSpec = VdlPsiImplUtil.findBaseSpecType(type);
            type = theLatestSpec instanceof VdlSpecType ? ((VdlSpecType)theLatestSpec).getType() : theLatestSpec;
        }
        if (type instanceof VdlStructOrUnionType) {
            VdlScopeProcessorBase delegate = createDelegate(processor);
            type.processDeclarations(delegate, ResolveState.initial(), null, myElement);
            List<VdlTypeReferenceExpression> interfaceRefs = ContainerUtil.newArrayList();
            List<VdlTypeReferenceExpression> structRefs = ContainerUtil.newArrayList();
            for (VdlFieldDeclaration d : ((VdlStructOrUnionType)type).getFieldDeclarationList()) {
                if (!VdlPsiImplUtil.processNamedElements(processor, state, d.getFieldDefinitionList(), localResolve)) return false;
                VdlAnonymousFieldDefinition anon = d.getAnonymousFieldDefinition();
                if (anon != null) {
                    (anon.getMul() != null ? structRefs : interfaceRefs).add(anon.getTypeReferenceExpression());
                    if (!VdlPsiImplUtil.processNamedElements(processor, state, ContainerUtil.createMaybeSingletonList(anon), localResolve)) return false;
                }
            }
            if (!processCollectedRefs(interfaceRefs, processor, state.put(POINTER, null))) return false;
            if (!processCollectedRefs(structRefs, processor, state)) return false;
        }
        else if (state.get(POINTER) == null && type instanceof VdlInterfaceType) {
            if (!VdlPsiImplUtil.processNamedElements(processor, state, ((VdlInterfaceType)type).getMethods(), localResolve, true)) return false;
            if (!processCollectedRefs(((VdlInterfaceType)type).getBaseTypesReferences(), processor, state)) return false;
        }
        else if (type instanceof VdlFunctionType) {
            VdlSignature signature = ((VdlFunctionType)type).getSignature();
            VdlResult result = signature != null ? signature.getResult() : null;
            VdlType resultType = result != null ? result.getType() : null;
            if (resultType != null && !processGoType(resultType, processor, state)) return false;
        }
        return true;
    }

    public static boolean isLocalResolve(@NotNull PsiFile originFile, @NotNull PsiFile externalFile) {
        if (!(originFile instanceof VdlFile) || !(externalFile instanceof VdlFile)) return false;
        VdlFile o1 = (VdlFile)originFile.getOriginalFile();
        VdlFile o2 = (VdlFile)externalFile.getOriginalFile();
        return Comparing.equal(o1.getPackageName(), o2.getPackageName());
    }

    private boolean processCollectedRefs(@NotNull List<VdlTypeReferenceExpression> refs,
                                         @NotNull VdlScopeProcessor processor,
                                         @NotNull ResolveState state) {
        for (VdlTypeReferenceExpression ref : refs) {
            if (!processInTypeRef(ref, processor, state)) return false;
        }
        return true;
    }

    private boolean processInTypeRef(@Nullable VdlTypeReferenceExpression refExpr, @NotNull final VdlScopeProcessor processor, @NotNull final ResolveState state) {
        PsiReference reference = refExpr != null ? refExpr.getReference() : null;
        PsiElement resolve = reference != null ? reference.resolve() : null;
        if (resolve instanceof VdlTypeOwner) {
            final VdlType type = ((VdlTypeOwner)resolve).getVdlType(state);
            if (type == null) return true;
            if (!processGoType(type, processor, state)) return false;
            if (type instanceof VdlSpecType) {
                VdlType inner = ((VdlSpecType)type).getType();
                if (inner instanceof VdlPointerType && state.get(POINTER) != null) return true;
                if (!processGoType(inner, processor, state.put(DONT_PROCESS_METHODS, true))) return false;
            }
            return true;
        }
        return true;
    }

    @Nullable
    private static String getPath(@Nullable PsiFile file) {
        if (file == null) return null;
        VirtualFile virtualFile = file.getOriginalFile().getVirtualFile();
        return virtualFile == null ? null : virtualFile.getPath();
    }

    protected static boolean processDirectory(@Nullable PsiDirectory dir,
                                              @Nullable VdlFile file,
                                              @Nullable String packageName,
                                              @NotNull VdlScopeProcessor processor,
                                              @NotNull ResolveState state,
                                              boolean localProcessing) {
        if (dir == null) return true;
        String filePath = getPath(file);
        for (PsiFile f : dir.getFiles()) {
            if (!(f instanceof VdlFile) || Comparing.equal(getPath(f), filePath)) continue;
            if (packageName != null && !packageName.equals(((VdlFile)f).getPackageName())) continue;
            if (!processFileEntities((VdlFile)f, processor, state, localProcessing)) return false;
        }
        return true;
    }

    private boolean processUnqualifiedResolve(@NotNull VdlFile file,
                                              @NotNull VdlScopeProcessor processor,
                                              @NotNull ResolveState state) {
        // todo: rewrite with qualification not with siblings
        VdlReceiverType receiverType = PsiTreeUtil.getPrevSiblingOfType(myElement, VdlReceiverType.class);
        if (receiverType != null) {
            return processGoType(receiverType, processor, state);
        }

        if (getIdentifier().textMatches("_")) return processor.execute(myElement, state);

        PsiElement parent = myElement.getParent();

        if (parent instanceof VdlSelectorExpr) {
            boolean result = processSelector((VdlSelectorExpr)parent, processor, state, myElement);
            if (processor.isCompletion()) return result;
            if (!result || VdlPsiImplUtil.prevDot(myElement)) return false;
        }

        PsiElement grandPa = parent.getParent();
        if (grandPa instanceof VdlSelectorExpr && !processSelector((VdlSelectorExpr)grandPa, processor, state, parent)) return false;

        if (VdlPsiImplUtil.prevDot(parent)) return false;

        if (!processBlock(processor, state, true)) return false;
        if (!processImports(file, processor, state, myElement)) return false;
        if (!processFileEntities(file, processor, state, true)) return false;
        if (!processDirectory(file.getOriginalFile().getParent(), file, file.getPackageName(), processor, state, true)) return false;
        return true;
    }

    private boolean processBlock(@NotNull VdlScopeProcessor processor, @NotNull ResolveState state, boolean localResolve) {
        VdlScopeProcessorBase delegate = createDelegate(processor);
        ResolveUtil.treeWalkUp(myElement, delegate);
        return VdlPsiImplUtil.processNamedElements(processor, state, delegate.getVariants(), localResolve);
    }

    static boolean processImports(@NotNull VdlFile file,
                                  @NotNull VdlScopeProcessor processor,
                                  @NotNull ResolveState state,
                                  @NotNull VdlCompositeElement element) {
        for (Map.Entry<String, Collection<VdlImportSpec>> entry : file.getImportMap().entrySet()) {
            for (VdlImportSpec o : entry.getValue()) {
                VdlImportString importString = o.getImportString();
                if (o.isDot()) {
                    PsiDirectory implicitDir = importString.resolve();
                    boolean resolved = !processDirectory(implicitDir, file, null, processor, state, false);
                    if (resolved && !processor.isCompletion()) {
                        putIfAbsent(o, element);
                    }
                    if (resolved) return false;
                }
                else {
                    if (o.getAlias() == null) {
                        PsiDirectory resolve = importString.resolve();
                        if (resolve != null && !processor.execute(resolve, state.put(ACTUAL_NAME, entry.getKey()))) return false;
                    }
                    // todo: multi-resolve into appropriate package clauses
                    if (!processor.execute(o, state.put(ACTUAL_NAME, entry.getKey()))) return false;
                }
            }
        }
        return true;
    }

    private boolean processSelector(@NotNull VdlSelectorExpr parent,
                                    @NotNull VdlScopeProcessor processor,
                                    @NotNull ResolveState state,
                                    @Nullable PsiElement another) {
        List<VdlExpression> list = parent.getExpressionList();
        if (list.size() > 1 && list.get(1).isEquivalentTo(another)) {
            VdlExpression e = list.get(0);
            List<VdlReferenceExpression> refs = ContainerUtil.newArrayList(PsiTreeUtil.findChildrenOfType(e, VdlReferenceExpression.class));
            VdlExpression o = refs.size() > 1 ? refs.get(refs.size() - 1) : e;
            PsiReference ref = o.getReference();
            PsiElement resolve = ref != null ? ref.resolve() : null;
            if (resolve == o) return processor.execute(myElement, state); // var c = C.call(); c.a.b.d;
            VdlType type = e.getVdlType(createContext());
            if (type != null && !processGoType(type, processor, state)) return false;
        }
        return true;
    }

    @NotNull
    public ResolveState createContext() {
        return ResolveState.initial().put(VdlPsiImplUtil.CONTEXT,
                SmartPointerManager.getInstance(myElement.getProject()).createSmartPsiElementPointer(myElement));
    }

    @NotNull
    private VdlVarProcessor createDelegate(@NotNull VdlScopeProcessor processor) {
        return new VdlVarProcessor(getIdentifier(), myElement, processor.isCompletion(), true) {
            @Override
            protected boolean crossOff(@NotNull PsiElement e) {
                if (e instanceof VdlFieldDefinition) return true;
                return super.crossOff(e) && !(e instanceof VdlTypeSpec);
            }
        };
    }

    private static boolean processFileEntities(@NotNull VdlFile file,
                                               @NotNull VdlScopeProcessor processor,
                                               @NotNull ResolveState state,
                                               boolean localProcessing) {
//        if (!VdlPsiImplUtil.processNamedElements(processor, state, file.getConstants(), localProcessing)) return false;
        if (!VdlPsiImplUtil.processNamedElements(processor, state, file.getVars(), localProcessing)) return false;
        if (!VdlPsiImplUtil.processNamedElements(processor, state, file.getTypes(), localProcessing)) return false;
        return true;
    }

    @NotNull
    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        getIdentifier().replace(VdlElementFactory.createIdentifierFromText(myElement.getProject(), newElementName));
        return myElement;
    }

    static void putIfAbsent(@NotNull PsiElement importElement, @NotNull PsiElement usage) {
        List<PsiElement> newList = ContainerUtil.newSmartList(usage);
        List<? extends PsiElement> list = importElement.getUserData(IMPORT_USERS);
        if (list != null) {
            newList.addAll(list);
        }
        importElement.putUserData(IMPORT_USERS, newList);
    }
}
