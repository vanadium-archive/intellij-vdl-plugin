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

public class VdlFallthroughStatementImpl extends VdlStatementImpl implements VdlFallthroughStatement {

  public VdlFallthroughStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitFallthroughStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getFallthrough() {
    return findNotNullChildByType(FALLTHROUGH);
  }

}
