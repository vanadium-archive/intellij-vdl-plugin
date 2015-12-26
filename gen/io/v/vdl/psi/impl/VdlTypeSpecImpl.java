// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.v.vdl.psi.VdlTypes.*;
import io.v.vdl.psi.VdlNamedElementImpl;
import io.v.vdl.psi.VdlTypeSpecStub;
import io.v.vdl.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class VdlTypeSpecImpl extends VdlNamedElementImpl<VdlTypeSpecStub> implements VdlTypeSpec {

  public VdlTypeSpecImpl(ASTNode node) {
    super(node);
  }

  public VdlTypeSpecImpl(VdlTypeSpecStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitTypeSpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VdlSpecType getSpecType() {
    return findNotNullChildByClass(VdlSpecType.class);
  }

  public boolean shouldGoDeeper() {
    return VdlPsiImplUtil.shouldGoDeeper(this);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    VdlSpecType p1 = getSpecType();
    return p1.getIdentifier();
  }

}
