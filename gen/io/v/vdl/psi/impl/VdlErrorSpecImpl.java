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

public class VdlErrorSpecImpl extends VdlCompositeElementImpl implements VdlErrorSpec {

  public VdlErrorSpecImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitErrorSpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VdlErrorDetail> getErrorDetailList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlErrorDetail.class);
  }

  @Override
  @NotNull
  public VdlErrorIdentifier getErrorIdentifier() {
    return findNotNullChildByClass(VdlErrorIdentifier.class);
  }

  @Override
  @NotNull
  public VdlParameters getParameters() {
    return findNotNullChildByClass(VdlParameters.class);
  }

  @Override
  @NotNull
  public PsiElement getLbrace() {
    return findNotNullChildByType(LBRACE);
  }

  @Override
  @NotNull
  public PsiElement getRbrace() {
    return findNotNullChildByType(RBRACE);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getSemicolonSynthetic() {
    return findChildByType(SEMICOLON_SYNTHETIC);
  }

}
