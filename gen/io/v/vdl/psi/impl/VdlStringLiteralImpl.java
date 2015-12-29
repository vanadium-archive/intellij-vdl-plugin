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
import io.v.vdl.VdlStringLiteralEscaper;

public class VdlStringLiteralImpl extends VdlExpressionImpl implements VdlStringLiteral {

  public VdlStringLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VdlVisitor) ((VdlVisitor)visitor).visitStringLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getRawString() {
    return findChildByType(RAW_STRING);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

  @NotNull
  public VdlStringLiteral updateText(String text) {
    return VdlPsiImplUtil.updateText(this, text);
  }

  @NotNull
  public VdlStringLiteralEscaper createLiteralTextEscaper() {
    return VdlPsiImplUtil.createLiteralTextEscaper(this);
  }

  public boolean isValidHost() {
    return VdlPsiImplUtil.isValidHost(this);
  }

}
