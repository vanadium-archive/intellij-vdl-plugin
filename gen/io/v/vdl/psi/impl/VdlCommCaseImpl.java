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

public class VdlCommCaseImpl extends VdlCompositeElementImpl implements VdlCommCase {

  public VdlCommCaseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitCommCase(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlRecvStatement getRecvStatement() {
    return findChildByClass(VdlRecvStatement.class);
  }

  @Override
  @Nullable
  public VdlSendStatement getSendStatement() {
    return findChildByClass(VdlSendStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getCase() {
    return findChildByType(CASE);
  }

  @Override
  @Nullable
  public PsiElement getDefault() {
    return findChildByType(DEFAULT);
  }

}
