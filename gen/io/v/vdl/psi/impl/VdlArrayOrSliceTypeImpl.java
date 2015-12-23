// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.v.vdl.psi.VdlTypes.*;
import io.v.vdl.psi.*;

public class VdlArrayOrSliceTypeImpl extends VdlTypeImpl implements VdlArrayOrSliceType {

  public VdlArrayOrSliceTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitArrayOrSliceType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlExpression getExpression() {
    return findChildByClass(VdlExpression.class);
  }

  @Override
  @Nullable
  public VdlType getType() {
    return findChildByClass(VdlType.class);
  }

  @Override
  @NotNull
  public PsiElement getLbrack() {
    return findNotNullChildByType(LBRACK);
  }

  @Override
  @Nullable
  public PsiElement getRbrack() {
    return findChildByType(RBRACK);
  }

  @Override
  @Nullable
  public PsiElement getTripleDot() {
    return findChildByType(TRIPLE_DOT);
  }

}
