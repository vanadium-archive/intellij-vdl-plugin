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

public class VdlForStatementImpl extends VdlStatementImpl implements VdlForStatement {

  public VdlForStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitForStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlBlock getBlock() {
    return findChildByClass(VdlBlock.class);
  }

  @Override
  @Nullable
  public VdlExpression getExpression() {
    return findChildByClass(VdlExpression.class);
  }

  @Override
  @Nullable
  public VdlForClause getForClause() {
    return findChildByClass(VdlForClause.class);
  }

  @Override
  @Nullable
  public VdlRangeClause getRangeClause() {
    return findChildByClass(VdlRangeClause.class);
  }

  @Override
  @NotNull
  public PsiElement getFor() {
    return findNotNullChildByType(FOR);
  }

}
