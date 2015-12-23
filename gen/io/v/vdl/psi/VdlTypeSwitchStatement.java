// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlTypeSwitchStatement extends VdlSwitchStatement {

  @Nullable
  VdlStatement getStatement();

  @NotNull
  VdlSwitchStart getSwitchStart();

  @NotNull
  List<VdlTypeCaseClause> getTypeCaseClauseList();

  @NotNull
  VdlTypeSwitchGuard getTypeSwitchGuard();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getSemicolon();

}
