// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlUnaryExpr extends VdlExpression {

  @Nullable
  VdlExpression getExpression();

  @Nullable
  PsiElement getBitAnd();

  @Nullable
  PsiElement getBitXor();

  @Nullable
  PsiElement getMinus();

  @Nullable
  PsiElement getMul();

  @Nullable
  PsiElement getNot();

  @Nullable
  PsiElement getPlus();

  @Nullable
  PsiElement getSendChannel();

}
