// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlRecvStatement extends VdlVarSpec {

  @NotNull
  List<VdlExpression> getExpressionList();

  @NotNull
  List<VdlVarDefinition> getVarDefinitionList();

  @Nullable
  PsiElement getAssign();

  @Nullable
  PsiElement getVarAssign();

}
