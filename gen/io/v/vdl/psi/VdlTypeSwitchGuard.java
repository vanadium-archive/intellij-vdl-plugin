// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlTypeSwitchGuard extends VdlCompositeElement {

  @NotNull
  VdlExpression getExpression();

  @NotNull
  VdlTypeGuard getTypeGuard();

  @Nullable
  VdlVarDefinition getVarDefinition();

  @NotNull
  PsiElement getDot();

  @Nullable
  PsiElement getVarAssign();

}
