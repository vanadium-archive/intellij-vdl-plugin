// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlConstSpec extends VdlCompositeElement {

  @NotNull
  List<VdlConstDefinition> getConstDefinitionList();

  @NotNull
  List<VdlExpression> getExpressionList();

  @Nullable
  VdlType getType();

  @Nullable
  PsiElement getAssign();

}
