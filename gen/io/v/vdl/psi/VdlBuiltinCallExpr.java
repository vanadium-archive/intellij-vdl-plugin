// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlBuiltinCallExpr extends VdlExpression {

  @Nullable
  VdlBuiltinArgs getBuiltinArgs();

  @NotNull
  VdlReferenceExpression getReferenceExpression();

  @Nullable
  PsiElement getComma();

  @NotNull
  PsiElement getLparen();

  @Nullable
  PsiElement getRparen();

}
