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

public class VdlFunctionTypeImpl extends VdlTypeImpl implements VdlFunctionType {

  public VdlFunctionTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VdlVisitor visitor) {
    visitor.visitFunctionType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) accept((VdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlSignature getSignature() {
    return findChildByClass(VdlSignature.class);
  }

  @Override
  @NotNull
  public PsiElement getFunc() {
    return findNotNullChildByType(FUNC);
  }

}
