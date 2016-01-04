// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;

public interface VdlImportSpec extends VdlNamedElement, StubBasedPsiElement<VdlImportSpecStub> {

  @NotNull
  VdlImportString getImportString();

  @Nullable
  PsiElement getDot();

  @Nullable
  PsiElement getIdentifier();

  String getAlias();

  boolean isDot();

  @NotNull
  String getPath();

  String getName();

  String getLocalPackageName();

}
