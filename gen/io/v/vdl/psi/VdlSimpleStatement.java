// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlSimpleStatement extends VdlStatement {

  @Nullable
  VdlLeftHandExprList getLeftHandExprList();

  @Nullable
  VdlShortVarDeclaration getShortVarDeclaration();

  @Nullable
  VdlStatement getStatement();

  @Nullable
  PsiElement getMinusMinus();

  @Nullable
  PsiElement getPlusPlus();

}
