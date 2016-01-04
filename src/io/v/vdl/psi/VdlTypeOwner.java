package io.v.vdl.psi;

import com.intellij.psi.ResolveState;
import org.jetbrains.annotations.Nullable;

public interface VdlTypeOwner extends VdlCompositeElement {
    @Nullable
    VdlType getVdlType(@Nullable ResolveState context);
}
