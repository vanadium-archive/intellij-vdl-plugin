// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface VdlTypeReferenceExpression extends VdlReferenceExpressionBase {

  @Nullable
  PsiElement getOptionalArg();

  @NotNull
  PsiElement getIdentifier();

  @NotNull
  PsiReference getReference();

  @Nullable
  VdlTypeReferenceExpression getQualifier();

}
