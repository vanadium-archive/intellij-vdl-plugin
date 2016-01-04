// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.v.vdl.psi.VdlTypes.*;
import io.v.vdl.psi.VdlStubbedElementImpl;
import io.v.vdl.psi.VdlTypeStub;
import io.v.vdl.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class VdlTypeImpl extends VdlStubbedElementImpl<VdlTypeStub> implements VdlType {

  public VdlTypeImpl(ASTNode node) {
    super(node);
  }

  public VdlTypeImpl(VdlTypeStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlTypeReferenceExpression getTypeReferenceExpression() {
    return findChildByClass(VdlTypeReferenceExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getError() {
    return findChildByType(ERROR);
  }

}
