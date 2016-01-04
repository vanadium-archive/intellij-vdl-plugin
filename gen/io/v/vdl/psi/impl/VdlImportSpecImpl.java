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
import io.v.vdl.psi.VdlImportSpecStub;
import io.v.vdl.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class VdlImportSpecImpl extends VdlNamedElementImpl<VdlImportSpecStub> implements VdlImportSpec {

  public VdlImportSpecImpl(ASTNode node) {
    super(node);
  }

  public VdlImportSpecImpl(VdlImportSpecStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitImportSpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VdlImportString getImportString() {
    return findNotNullChildByClass(VdlImportString.class);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(DOT);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  public String getAlias() {
    return VdlPsiImplUtil.getAlias(this);
  }

  public boolean isDot() {
    return VdlPsiImplUtil.isDot(this);
  }

  @NotNull
  public String getPath() {
    return VdlPsiImplUtil.getPath(this);
  }

  public String getName() {
    return VdlPsiImplUtil.getName(this);
  }

  public String getLocalPackageName() {
    return VdlPsiImplUtil.getLocalPackageName(this);
  }

}
