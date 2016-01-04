// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;

public interface VdlMethodSpec extends VdlNamedElement, StubBasedPsiElement<VdlMethodSpecStub> {

  @Nullable
  VdlSignature getSignature();

  @Nullable
  VdlTags getTags();

  @Nullable
  VdlTypeReferenceExpression getTypeReferenceExpression();

  @Nullable
  PsiElement getError();

  @Nullable
  PsiElement getIdentifier();

}
