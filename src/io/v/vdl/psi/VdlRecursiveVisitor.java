package io.v.vdl.psi;

import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class VdlRecursiveVisitor extends VdlVisitor {
    @Override
    public void visitCompositeElement(@NotNull VdlCompositeElement o) {
        for (PsiElement psiElement : o.getChildren()) {
            if (psiElement instanceof VdlCompositeElement) {
                psiElement.accept(this);
                ProgressIndicatorProvider.checkCanceled();
            }
        }
    }

    @Override
    public void visitFile(@NotNull PsiFile file) {
        for (PsiElement psiElement : file.getChildren()) {
            if (psiElement instanceof VdlCompositeElement) {
                psiElement.accept(this);
                ProgressIndicatorProvider.checkCanceled();
            }
        }
    }

}
