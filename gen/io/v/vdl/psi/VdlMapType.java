// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlMapType extends VdlType {

  @NotNull
  List<VdlType> getTypeList();

  @Nullable
  PsiElement getLbrack();

  @Nullable
  PsiElement getRbrack();

  @NotNull
  PsiElement getMap();

  @Nullable
  VdlType getKeyType();

  @Nullable
  VdlType getValueType();

}
