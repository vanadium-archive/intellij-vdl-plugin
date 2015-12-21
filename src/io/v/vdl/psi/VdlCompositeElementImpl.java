package io.v.vdl.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class VdlCompositeElementImpl extends ASTWrapperPsiElement implements VdlCompositeElement {
    public VdlCompositeElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return getNode().getElementType().toString();
    }

    @Override
    public boolean shouldGoDeeper() {
        return true;
    }

}
