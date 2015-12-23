// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlTypeAssertionExpr extends VdlExpression {

  @NotNull
  VdlExpression getExpression();

  @NotNull
  VdlType getType();

  @NotNull
  PsiElement getDot();

  @NotNull
  PsiElement getLparen();

  @NotNull
  PsiElement getRparen();

}
