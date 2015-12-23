// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlErrorSpec extends VdlCompositeElement {

  @NotNull
  List<VdlErrorDetail> getErrorDetailList();

  @NotNull
  VdlErrorIdentifier getErrorIdentifier();

  @NotNull
  VdlParameters getParameters();

  @NotNull
  PsiElement getLbrace();

  @NotNull
  PsiElement getRbrace();

  @Nullable
  PsiElement getSemicolon();

  @Nullable
  PsiElement getSemicolonSynthetic();

}
