// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlExprSwitchStatement extends VdlSwitchStatement {

  @NotNull
  List<VdlExprCaseClause> getExprCaseClauseList();

  @Nullable
  VdlExpression getExpression();

  @Nullable
  VdlStatement getStatement();

  @NotNull
  VdlSwitchStart getSwitchStart();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getSemicolon();

}
