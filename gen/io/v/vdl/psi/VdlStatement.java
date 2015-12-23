// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VdlStatement extends VdlCompositeElement {

  @Nullable
  VdlBlock getBlock();

  @Nullable
  VdlConstDeclaration getConstDeclaration();

  @Nullable
  VdlTypeDeclaration getTypeDeclaration();

  @Nullable
  VdlVarDeclaration getVarDeclaration();

}
