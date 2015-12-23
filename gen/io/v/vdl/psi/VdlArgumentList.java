// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlArgumentList extends VdlCompositeElement {

  @NotNull
  List<VdlExpression> getExpressionList();

  @NotNull
  PsiElement getLparen();

  @Nullable
  PsiElement getRparen();

  @Nullable
  PsiElement getTripleDot();

}
