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

public class VdlSimpleStatementImpl extends VdlStatementImpl implements VdlSimpleStatement {

  public VdlSimpleStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitSimpleStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlLeftHandExprList getLeftHandExprList() {
    return findChildByClass(VdlLeftHandExprList.class);
  }

  @Override
  @Nullable
  public VdlShortVarDeclaration getShortVarDeclaration() {
    return findChildByClass(VdlShortVarDeclaration.class);
  }

  @Override
  @Nullable
  public VdlStatement getStatement() {
    return findChildByClass(VdlStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getMinusMinus() {
    return findChildByType(MINUS_MINUS);
  }

  @Override
  @Nullable
  public PsiElement getPlusPlus() {
    return findChildByType(PLUS_PLUS);
  }

}
