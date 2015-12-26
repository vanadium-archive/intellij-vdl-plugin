// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;

public interface VdlTypeSpec extends VdlNamedElement, StubBasedPsiElement<VdlTypeSpecStub> {

  @NotNull
  VdlSpecType getSpecType();

  boolean shouldGoDeeper();

  @NotNull
  PsiElement getIdentifier();

}
