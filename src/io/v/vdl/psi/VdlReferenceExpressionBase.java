package io.v.vdl.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface VdlReferenceExpressionBase extends VdlCompositeElement {
    @NotNull
    PsiElement getIdentifier();

    @Nullable
    VdlReferenceExpressionBase getQualifier();
}
