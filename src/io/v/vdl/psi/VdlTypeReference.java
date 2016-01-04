// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiPolyVariantReferenceBase;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.containers.OrderedSet;
import io.v.vdl.VdlUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class VdlTypeReference extends PsiPolyVariantReferenceBase<VdlTypeReferenceExpression> {
    private final boolean myInsideInterfaceType;

    public VdlTypeReference(@NotNull VdlTypeReferenceExpression o) {
        super(o, TextRange.from(o.getIdentifier().getStartOffsetInParent(), o.getIdentifier().getTextLength()));
        myInsideInterfaceType = myElement.getParent() instanceof VdlMethodSpec;
    }

    private static final ResolveCache.PolyVariantResolver<PsiPolyVariantReferenceBase> MY_RESOLVER =
            new ResolveCache.PolyVariantResolver<PsiPolyVariantReferenceBase>() {
                @NotNull
                @Override
                public ResolveResult[] resolve(@NotNull PsiPolyVariantReferenceBase psiPolyVariantReferenceBase, boolean incompleteCode) {
                    return ((VdlTypeReference)psiPolyVariantReferenceBase).resolveInner();
                }
            };

    @NotNull
    private ResolveResult[] resolveInner() {
        Collection<ResolveResult> result = new OrderedSet<ResolveResult>();
        processResolveVariants(VdlReference.createResolveProcessor(result, myElement));

        if (result.isEmpty() && myElement.getParent() instanceof VdlReceiverType) {
            PsiElement resolve = new VdlReference(myElement).resolve();
            if (resolve != null) {
                return PsiElementResolveResult.createResults(resolve);
            }
        }

        return result.toArray(new ResolveResult[result.size()]);
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
        return VdlUtil.couldBeReferenceTo(element, myElement) && super.isReferenceTo(element);
    }

    @NotNull
    private PsiElement getIdentifier() {
        return myElement.getIdentifier();
    }

    @Override
    @NotNull
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        return myElement.isValid()
                ? ResolveCache.getInstance(myElement.getProject()).resolveWithCaching(this, MY_RESOLVER, false, false)
                : ResolveResult.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    public boolean processResolveVariants(@NotNull VdlScopeProcessor processor) {
        PsiFile file = myElement.getContainingFile();
        if (!(file instanceof VdlFile)) return false;
        ResolveState state = ResolveState.initial();
        VdlTypeReferenceExpression qualifier = myElement.getQualifier();
        if (qualifier != null) {
            return processQualifierExpression(((VdlFile)file), qualifier, processor, state);
        }
        return processUnqualifiedResolve(((VdlFile)file), processor, state, true);
    }

    private boolean processQualifierExpression(@NotNull VdlFile file,
                                               @NotNull VdlTypeReferenceExpression qualifier,
                                               @NotNull VdlScopeProcessor processor,
                                               @NotNull ResolveState state) {
        PsiElement target = qualifier.getReference().resolve();
        if (target == null || target == qualifier) return false;
        if (target instanceof VdlImportSpec) {
            target = ((VdlImportSpec)target).getImportString().resolve();
        }
        if (target instanceof PsiDirectory) {
            VdlReference.processDirectory((PsiDirectory)target, file, null, processor, state, false);
        }
        return false;
    }

    private boolean processUnqualifiedResolve(@NotNull VdlFile file,
                                              @NotNull VdlScopeProcessor processor,
                                              @NotNull ResolveState state,
                                              boolean localResolve) {
        VdlScopeProcessorBase delegate = createDelegate(processor);
        ResolveUtil.treeWalkUp(myElement, delegate);
        Collection<? extends VdlNamedElement> result = delegate.getVariants();
        if (!processNamedElements(processor, state, result, localResolve)) return false;
        if (!processFileEntities(file, processor, state, localResolve)) return false;
        PsiDirectory dir = file.getOriginalFile().getParent();
        if (!VdlReference.processDirectory(dir, file, file.getPackageName(), processor, state, true)) return false;
        return VdlReference.processImports(file, processor, state, myElement);
    }

    @NotNull
    private VdlTypeProcessor createDelegate(@NotNull VdlScopeProcessor processor) {
        return new VdlTypeProcessor(myElement, processor.isCompletion());
    }

    private boolean processFileEntities(@NotNull VdlFile file,
                                        @NotNull VdlScopeProcessor processor,
                                        @NotNull ResolveState state,
                                        boolean localProcessing) {
        return processNamedElements(processor, state, file.getTypes(), localProcessing);
    }

    private boolean processNamedElements(@NotNull PsiScopeProcessor processor,
                                         @NotNull ResolveState state,
                                         @NotNull Collection<? extends VdlNamedElement> elements, boolean localResolve) {
        for (VdlNamedElement definition : elements) {
            if (definition instanceof VdlTypeSpec && !allowed((VdlTypeSpec)definition)) continue;
            if ((definition.isPublic() || localResolve) && !processor.execute(definition, state)) return false;
        }
        return true;
    }

    public boolean allowed(@NotNull VdlTypeSpec definition) {
        return !myInsideInterfaceType || (definition.getSpecType().getType() instanceof VdlInterfaceType);
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        getIdentifier().replace(VdlElementFactory.createIdentifierFromText(myElement.getProject(), newElementName));
        return myElement;
    }
}
