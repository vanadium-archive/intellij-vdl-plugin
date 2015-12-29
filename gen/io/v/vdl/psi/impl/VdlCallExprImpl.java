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

public class VdlCallExprImpl extends VdlExpressionImpl implements VdlCallExpr {

  public VdlCallExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitCallExpr(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VdlArgumentList getArgumentList() {
    return findNotNullChildByClass(VdlArgumentList.class);
  }

  @Override
  @NotNull
  public VdlExpression getExpression() {
    return findNotNullChildByClass(VdlExpression.class);
  }

}
