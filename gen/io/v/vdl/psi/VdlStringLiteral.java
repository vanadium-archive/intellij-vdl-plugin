// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import io.v.vdl.VdlStringLiteralEscaper;

public interface VdlStringLiteral extends VdlExpression, PsiLanguageInjectionHost {

  @Nullable
  PsiElement getRawString();

  @Nullable
  PsiElement getString();

  @NotNull
  VdlStringLiteral updateText(String text);

  @NotNull
  VdlStringLiteralEscaper createLiteralTextEscaper();

  boolean isValidHost();

}
