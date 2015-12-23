// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlParameterDeclaration extends VdlCompositeElement {

  @NotNull
  List<VdlParamDefinition> getParamDefinitionList();

  @NotNull
  VdlType getType();

  @Nullable
  PsiElement getTripleDot();

}
