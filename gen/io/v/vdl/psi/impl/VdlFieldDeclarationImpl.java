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

public class VdlFieldDeclarationImpl extends VdlCompositeElementImpl implements VdlFieldDeclaration {

  public VdlFieldDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitFieldDeclaration(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VdlAnonymousFieldDefinition getAnonymousFieldDefinition() {
    return findChildByClass(VdlAnonymousFieldDefinition.class);
  }

  @Override
  @NotNull
  public List<VdlFieldDefinition> getFieldDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VdlFieldDefinition.class);
  }

  @Override
  @Nullable
  public VdlTag getTag() {
    return findChildByClass(VdlTag.class);
  }

  @Override
  @Nullable
  public VdlType getType() {
    return findChildByClass(VdlType.class);
  }

}
