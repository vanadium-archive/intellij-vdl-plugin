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

public class VdlSwitchStatementImpl extends VdlStatementImpl implements VdlSwitchStatement {

  public VdlSwitchStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitSwitchStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlSwitchStart getSwitchStart() {
    return findChildByClass(VdlSwitchStart.class);
  }

  @Override
  @Nullable
  public VdlSwitchStatement getSwitchStatement() {
    return findChildByClass(VdlSwitchStatement.class);
  }

}
