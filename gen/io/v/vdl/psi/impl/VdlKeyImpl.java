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

public class VdlKeyImpl extends VdlCompositeElementImpl implements VdlKey {

  public VdlKeyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitKey(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlExpression getExpression() {
    return findChildByClass(VdlExpression.class);
  }

  @Override
  @Nullable
  public VdlFieldName getFieldName() {
    return findChildByClass(VdlFieldName.class);
  }

}
