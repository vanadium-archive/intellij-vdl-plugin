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

public class VdlResultImpl extends VdlCompositeElementImpl implements VdlResult {

  public VdlResultImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitResult(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlErrorResult getErrorResult() {
    return findChildByClass(VdlErrorResult.class);
  }

  @Override
  @Nullable
  public VdlErrorTypeName getErrorTypeName() {
    return findChildByClass(VdlErrorTypeName.class);
  }

  @Override
  @Nullable
  public VdlParameters getParameters() {
    return findChildByClass(VdlParameters.class);
  }

  @Override
  @Nullable
  public VdlType getType() {
    return findChildByClass(VdlType.class);
  }

  @Override
  @Nullable
  public PsiElement getLparen() {
    return findChildByType(LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getRparen() {
    return findChildByType(RPAREN);
  }

}
