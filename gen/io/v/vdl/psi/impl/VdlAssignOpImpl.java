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

public class VdlAssignOpImpl extends VdlCompositeElementImpl implements VdlAssignOp {

  public VdlAssignOpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitAssignOp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getAssign() {
    return findChildByType(ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getBitAndAssign() {
    return findChildByType(BIT_AND_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getBitClearAssign() {
    return findChildByType(BIT_CLEAR_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getBitOrAssign() {
    return findChildByType(BIT_OR_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getBitXorAssign() {
    return findChildByType(BIT_XOR_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getMinusAssign() {
    return findChildByType(MINUS_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getMulAssign() {
    return findChildByType(MUL_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getPlusAssign() {
    return findChildByType(PLUS_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getQuotientAssign() {
    return findChildByType(QUOTIENT_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getRemainderAssign() {
    return findChildByType(REMAINDER_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getShiftLeftAssign() {
    return findChildByType(SHIFT_LEFT_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getShiftRightAssign() {
    return findChildByType(SHIFT_RIGHT_ASSIGN);
  }

}
