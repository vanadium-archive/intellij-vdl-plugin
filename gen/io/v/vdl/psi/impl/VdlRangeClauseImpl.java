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
import com.intellij.psi.stubs.IStubElementType;

public class VdlRangeClauseImpl extends VdlVarSpecImpl implements VdlRangeClause {

  public VdlRangeClauseImpl(ASTNode node) {
    super(node);
  }

  public VdlRangeClauseImpl(VdlVarSpecStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitRangeClause(this);
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
  public List<VdlVarDefinition> getVarDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlVarDefinition.class);
  }

  @Override
  @Nullable
  public PsiElement getAssign() {
    return findChildByType(ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getVarAssign() {
    return findChildByType(VAR_ASSIGN);
  }

  @Override
  @NotNull
  public PsiElement getRange() {
    return findNotNullChildByType(RANGE);
  }

}
