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

public class VdlBinaryExprImpl extends VdlExpressionImpl implements VdlBinaryExpr {

  public VdlBinaryExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitBinaryExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VdlExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlExpression.class);
  }

  @Override
  @NotNull
  public VdlExpression getLeft() {
    List<VdlExpression> p1 = getExpressionList();
    return p1.get(0);
  }

  @Override
  @Nullable
  public VdlExpression getRight() {
    List<VdlExpression> p1 = getExpressionList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
