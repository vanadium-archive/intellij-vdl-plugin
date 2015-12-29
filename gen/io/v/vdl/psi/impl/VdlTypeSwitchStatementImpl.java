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

public class VdlTypeSwitchStatementImpl extends VdlSwitchStatementImpl implements VdlTypeSwitchStatement {

  public VdlTypeSwitchStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitTypeSwitchStatement(this);
    else super.accept(visitor);
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
  public List<VdlTypeCaseClause> getTypeCaseClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlTypeCaseClause.class);
  }

  @Override
  @NotNull
  public VdlTypeSwitchGuard getTypeSwitchGuard() {
    return findNotNullChildByClass(VdlTypeSwitchGuard.class);
  }

  @Override
  @Nullable
  public PsiElement getLbrace() {
    return findChildByType(LBRACE);
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
