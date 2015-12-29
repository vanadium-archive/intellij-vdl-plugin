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
import io.v.vdl.psi.VdlMethodSpecStub;
import io.v.vdl.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class VdlMethodSpecImpl extends VdlNamedElementImpl<VdlMethodSpecStub> implements VdlMethodSpec {

  public VdlMethodSpecImpl(ASTNode node) {
    super(node);
  }

  public VdlMethodSpecImpl(VdlMethodSpecStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitMethodSpec(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlErrorTypeName getErrorTypeName() {
    return findChildByClass(VdlErrorTypeName.class);
  }

  @Override
  @Nullable
  public VdlSignature getSignature() {
    return findChildByClass(VdlSignature.class);
  }

  @Override
  @Nullable
  public VdlTags getTags() {
    return findChildByClass(VdlTags.class);
  }

  @Override
  @Nullable
  public VdlTypeReferenceExpression getTypeReferenceExpression() {
    return findChildByClass(VdlTypeReferenceExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
