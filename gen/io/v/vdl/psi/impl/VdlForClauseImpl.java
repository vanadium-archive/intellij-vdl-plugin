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

public class VdlForClauseImpl extends VdlCompositeElementImpl implements VdlForClause {

  public VdlForClauseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitForClause(this);
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
  @NotNull
  public List<VdlStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlStatement.class);
  }

}
