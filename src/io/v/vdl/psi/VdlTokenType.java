package io.v.vdl.psi;

import com.intellij.psi.tree.IElementType;
import io.v.vdl.VdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class VdlTokenType extends IElementType {
    public VdlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, VdlLanguage.INSTANCE);
    }
}
