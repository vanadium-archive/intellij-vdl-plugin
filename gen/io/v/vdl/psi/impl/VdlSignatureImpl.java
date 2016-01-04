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

public class VdlSignatureImpl extends VdlCompositeElementImpl implements VdlSignature {

  public VdlSignatureImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitSignature(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VdlParameters getParameters() {
    return findNotNullChildByClass(VdlParameters.class);
  }

  @Override
  @NotNull
  public VdlResult getResult() {
    return findNotNullChildByClass(VdlResult.class);
  }

  @Override
  @Nullable
  public VdlStreamSpec getStreamSpec() {
    return findChildByClass(VdlStreamSpec.class);
  }

}
