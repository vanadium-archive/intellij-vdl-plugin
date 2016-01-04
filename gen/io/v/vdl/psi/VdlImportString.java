// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiDirectory;

public interface VdlImportString extends VdlCompositeElement {

  @Nullable
  PsiElement getRawString();

  @Nullable
  PsiElement getString();

  @NotNull
  String getPath();

  @Nullable
  PsiDirectory resolve();

}
