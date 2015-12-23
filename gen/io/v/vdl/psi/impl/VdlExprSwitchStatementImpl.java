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

public class VdlExprSwitchStatementImpl extends VdlSwitchStatementImpl implements VdlExprSwitchStatement {

  public VdlExprSwitchStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitExprSwitchStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VdlExprCaseClause> getExprCaseClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlExprCaseClause.class);
  }

  @Override
  @Nullable
  public VdlExpression getExpression() {
    return findChildByClass(VdlExpression.class);
  }

  @Override
  @Nullable
  public VdlStatement getStatement() {
    return findChildByClass(VdlStatement.class);
  }

  @Override
  @NotNull
  public VdlSwitchStart getSwitchStart() {
    return findNotNullChildByClass(VdlSwitchStart.class);
  }

  @Override
  @NotNull
  public PsiElement getLbrace() {
    return findNotNullChildByType(LBRACE);
  }

  @Override
  @Nullable
  public PsiElement getRbrace() {
    return findChildByType(RBRACE);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

}
