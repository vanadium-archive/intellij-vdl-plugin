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

public class VdlLabeledStatementImpl extends VdlStatementImpl implements VdlLabeledStatement {

  public VdlLabeledStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitLabeledStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VdlLabelDefinition getLabelDefinition() {
    return findNotNullChildByClass(VdlLabelDefinition.class);
  }

  @Override
  @Nullable
  public VdlStatement getStatement() {
    return findChildByClass(VdlStatement.class);
  }

  @Override
  @NotNull
  public PsiElement getColon() {
    return findNotNullChildByType(COLON);
  }

}
