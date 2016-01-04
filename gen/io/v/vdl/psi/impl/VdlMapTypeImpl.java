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
import com.intellij.psi.stubs.IStubElementType;

public class VdlMapTypeImpl extends VdlTypeImpl implements VdlMapType {

  public VdlMapTypeImpl(ASTNode node) {
    super(node);
  }

  public VdlMapTypeImpl(VdlTypeStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitMapType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VdlType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlType.class);
  }

  @Override
  @Nullable
  public PsiElement getLbrack() {
    return findChildByType(LBRACK);
  }

  @Override
  @Nullable
  public PsiElement getRbrack() {
    return findChildByType(RBRACK);
  }

  @Override
  @NotNull
  public PsiElement getMap() {
    return findNotNullChildByType(MAP);
  }

  @Override
  @Nullable
  public VdlType getKeyType() {
    List<VdlType> p1 = getTypeList();
    return p1.size() < 1 ? null : p1.get(0);
  }

  @Override
  @Nullable
  public VdlType getValueType() {
    List<VdlType> p1 = getTypeList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
