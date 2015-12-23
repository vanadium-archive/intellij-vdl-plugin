// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlErrorDeclaration extends VdlCompositeElement {

  @NotNull
  List<VdlErrorSpec> getErrorSpecList();

  @Nullable
  PsiElement getLparen();

  @Nullable
  PsiElement getRparen();

  @NotNull
  PsiElement getError();

}
