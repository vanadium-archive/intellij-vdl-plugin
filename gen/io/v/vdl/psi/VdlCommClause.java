// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlCommClause extends VdlCompositeElement {

  @NotNull
  VdlCommCase getCommCase();

  @NotNull
  List<VdlStatement> getStatementList();

  @Nullable
  PsiElement getColon();

}
