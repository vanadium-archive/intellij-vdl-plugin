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

public class VdlTypeSwitchGuardImpl extends VdlCompositeElementImpl implements VdlTypeSwitchGuard {

  public VdlTypeSwitchGuardImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitTypeSwitchGuard(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VdlExpression getExpression() {
    return findNotNullChildByClass(VdlExpression.class);
  }

  @Override
  @NotNull
  public VdlTypeGuard getTypeGuard() {
    return findNotNullChildByClass(VdlTypeGuard.class);
  }

  @Override
  @Nullable
  public VdlVarDefinition getVarDefinition() {
    return findChildByClass(VdlVarDefinition.class);
  }

  @Override
  @NotNull
  public PsiElement getDot() {
    return findNotNullChildByType(DOT);
  }

  @Override
  @Nullable
  public PsiElement getVarAssign() {
    return findChildByType(VAR_ASSIGN);
  }

}
