package io.v.vdl.psi;

import org.jetbrains.annotations.Nullable;

public interface VdlNamedSignatureOwner extends VdlNamedElement {
    @Nullable
    VdlSignature getSignature();
}
