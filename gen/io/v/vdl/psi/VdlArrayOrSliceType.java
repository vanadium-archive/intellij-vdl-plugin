// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlArrayOrSliceType extends VdlType {

  @Nullable
  VdlExpression getExpression();

  @Nullable
  VdlType getType();

  @NotNull
  PsiElement getLbrack();

  @Nullable
  PsiElement getRbrack();

  @Nullable
  PsiElement getTripleDot();

}
