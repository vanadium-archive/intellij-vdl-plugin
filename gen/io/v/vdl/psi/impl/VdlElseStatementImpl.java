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

public class VdlElseStatementImpl extends VdlStatementImpl implements VdlElseStatement {

  public VdlElseStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitElseStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlBlock getBlock() {
    return findChildByClass(VdlBlock.class);
  }

  @Override
  @Nullable
  public VdlIfStatement getIfStatement() {
    return findChildByClass(VdlIfStatement.class);
  }

  @Override
  @NotNull
  public PsiElement getElse() {
    return findNotNullChildByType(ELSE);
  }

}
