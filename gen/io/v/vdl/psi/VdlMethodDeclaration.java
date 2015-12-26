// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;

public interface VdlMethodDeclaration extends VdlNamedElement, StubBasedPsiElement<VdlMethodDeclarationStub> {

  @Nullable
  VdlBlock getBlock();

  @NotNull
  VdlReceiver getReceiver();

  @Nullable
  VdlSignature getSignature();

  @NotNull
  PsiElement getFunc();

  @Nullable
  PsiElement getIdentifier();

}
