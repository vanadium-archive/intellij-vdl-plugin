// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlBinaryExpr extends VdlExpression {

  @NotNull
  List<VdlExpression> getExpressionList();

  @NotNull
  VdlExpression getLeft();

  @Nullable
  VdlExpression getRight();

}
