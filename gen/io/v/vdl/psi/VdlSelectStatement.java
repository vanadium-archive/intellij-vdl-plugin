// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlSelectStatement extends VdlStatement {

  @NotNull
  List<VdlCommClause> getCommClauseList();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @NotNull
  PsiElement getSelect();

}
