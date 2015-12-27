// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlStructOrUnionType extends VdlType {

  @NotNull
  List<VdlFieldDeclaration> getFieldDeclarationList();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getStruct();

  @Nullable
  PsiElement getUnion();

}
