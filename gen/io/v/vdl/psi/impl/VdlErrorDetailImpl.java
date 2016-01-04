// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.v.vdl.psi.VdlTypes.*;
import io.v.vdl.psi.VdlCompositeElementImpl;
import io.v.vdl.psi.*;

public class VdlErrorDetailImpl extends VdlCompositeElementImpl implements VdlErrorDetail {

  public VdlErrorDetailImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitErrorDetail(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlActionIdentifier getActionIdentifier() {
    return findChildByClass(VdlActionIdentifier.class);
  }

  @Override
  @Nullable
  public VdlErrorLanguageSpec getErrorLanguageSpec() {
    return findChildByClass(VdlErrorLanguageSpec.class);
  }

}
