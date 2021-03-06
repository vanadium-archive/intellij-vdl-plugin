// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlTypeCaseClause extends VdlCompositeElement {

  @NotNull
  List<VdlStatement> getStatementList();

  @Nullable
  VdlType getType();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getCase();

  @Nullable
  PsiElement getDefault();

}
