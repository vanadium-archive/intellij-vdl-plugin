// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlMulExpr extends VdlBinaryExpr {

  @NotNull
  List<VdlExpression> getExpressionList();

  @Nullable
  PsiElement getBitAnd();

  @Nullable
  PsiElement getBitClear();

  @Nullable
  PsiElement getMul();

  @Nullable
  PsiElement getQuotient();

  @Nullable
  PsiElement getRemainder();

  @Nullable
  PsiElement getShiftLeft();

  @Nullable
  PsiElement getShiftRight();

}
