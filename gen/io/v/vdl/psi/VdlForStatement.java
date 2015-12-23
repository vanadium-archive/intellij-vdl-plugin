// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlForStatement extends VdlStatement {

  @Nullable
  VdlBlock getBlock();

  @Nullable
  VdlExpression getExpression();

  @Nullable
  VdlForClause getForClause();

  @Nullable
  VdlRangeClause getRangeClause();

  @NotNull
  PsiElement getFor();

}
