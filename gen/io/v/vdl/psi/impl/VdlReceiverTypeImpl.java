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

public class VdlReceiverTypeImpl extends VdlTypeImpl implements VdlReceiverType {

  public VdlReceiverTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitReceiverType(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlErrorTypeName getErrorTypeName() {
    return findChildByClass(VdlErrorTypeName.class);
  }

  @Override
  @Nullable
  public VdlReceiverType getReceiverType() {
    return findChildByClass(VdlReceiverType.class);
  }

  @Override
  @Nullable
  public VdlTypeReferenceExpression getTypeReferenceExpression() {
    return findChildByClass(VdlTypeReferenceExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getLparen() {
    return findChildByType(LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getMul() {
    return findChildByType(MUL);
  }

  @Override
  @Nullable
  public PsiElement getRparen() {
    return findChildByType(RPAREN);
  }

}
