package io.v.vdl.psi;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.OrderedSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class VdlScopeProcessorBase extends VdlScopeProcessor {
    @NotNull
    private final OrderedSet<VdlNamedElement> myResult = new OrderedSet<VdlNamedElement>();
    @NotNull protected final PsiElement myOrigin;
    @NotNull private final PsiElement myRequestedNameElement;
    protected final boolean myIsCompletion;

    public VdlScopeProcessorBase(@NotNull PsiElement origin) {
        this(origin, origin, false);
    }

    public VdlScopeProcessorBase(@NotNull PsiElement requestedNameElement, @NotNull PsiElement origin, boolean completion) {
        myRequestedNameElement = requestedNameElement;
        myOrigin = origin;
        myIsCompletion = completion;
    }

    @Override
    public boolean execute(@NotNull PsiElement e, @NotNull ResolveState state) {
        if (e instanceof VdlFunctionDeclaration) return false;
        if (!(e instanceof VdlNamedElement)) return true;
        String name = ((VdlNamedElement)e).getName();
        if (StringUtil.isEmpty(name) || !myIsCompletion && !myRequestedNameElement.textMatches(name)) return true;
        if (crossOff(e)) return true;
        if (e.equals(myOrigin)) return true;
        return add((VdlNamedElement)e) || myIsCompletion;
    }

    protected boolean add(@NotNull VdlNamedElement psiElement) {
        return !myResult.add(psiElement);
    }

    @Nullable
    public VdlNamedElement getResult() {
        return ContainerUtil.getFirstItem(myResult);
    }

    @NotNull
    public List<VdlNamedElement> getVariants() {
        return myResult;
    }

    protected abstract boolean crossOff(@NotNull PsiElement e);

}
