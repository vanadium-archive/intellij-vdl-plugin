// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlResultParameters extends VdlCompositeElement {

  @Nullable
  VdlErrorResult getErrorResult();

  @NotNull
  List<VdlParameterDeclaration> getParameterDeclarationList();

  @Nullable
  VdlType getType();

  @NotNull
  PsiElement getLparen();

  @NotNull
  PsiElement getRparen();

}
