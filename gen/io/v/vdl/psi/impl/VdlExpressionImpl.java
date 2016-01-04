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
import com.intellij.psi.ResolveState;

public class VdlExpressionImpl extends VdlCompositeElementImpl implements VdlExpression {

  public VdlExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitExpression(this);
    else super.accept(visitor);
  }

  @Nullable
  public VdlType getVdlType(ResolveState context) {
    return VdlPsiImplUtil.getVdlType(this, context);
  }

}
