// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;

public interface VdlVarSpec extends VdlCompositeElement, StubBasedPsiElement<VdlVarSpecStub> {

  @NotNull
  List<VdlExpression> getExpressionList();

  @Nullable
  VdlType getType();

  @NotNull
  List<VdlVarDefinition> getVarDefinitionList();

  @Nullable
  PsiElement getAssign();

}
