// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlAddExpr extends VdlBinaryExpr {

  @NotNull
  List<VdlExpression> getExpressionList();

  @Nullable
  PsiElement getBitOr();

  @Nullable
  PsiElement getBitXor();

  @Nullable
  PsiElement getMinus();

  @Nullable
  PsiElement getPlus();

}
