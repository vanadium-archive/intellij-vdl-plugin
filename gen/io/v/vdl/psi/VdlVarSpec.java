// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlVarSpec extends VdlCompositeElement {

  @NotNull
  List<VdlExpression> getExpressionList();

  @Nullable
  VdlType getType();

  @NotNull
  List<VdlVarDefinition> getVarDefinitionList();

  @Nullable
  PsiElement getAssign();

}
