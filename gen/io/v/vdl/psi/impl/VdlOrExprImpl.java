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

public class VdlOrExprImpl extends VdlBinaryExprImpl implements VdlOrExpr {

  public VdlOrExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitOrExpr(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VdlExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getCondOr() {
    return findNotNullChildByType(COND_OR);
  }

}
