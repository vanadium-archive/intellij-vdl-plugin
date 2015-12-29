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

public class VdlBreakStatementImpl extends VdlStatementImpl implements VdlBreakStatement {

  public VdlBreakStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitBreakStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlLabelRef getLabelRef() {
    return findChildByClass(VdlLabelRef.class);
  }

  @Override
  @NotNull
  public PsiElement getBreak() {
    return findNotNullChildByType(BREAK);
  }

}
