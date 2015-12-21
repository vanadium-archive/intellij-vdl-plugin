package io.v.vdl.psi;

import com.intellij.psi.PsiElement;

public interface VdlCompositeElement extends PsiElement {
    boolean shouldGoDeeper();
}
