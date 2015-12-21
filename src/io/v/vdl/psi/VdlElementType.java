package io.v.vdl.psi;

import com.intellij.psi.tree.IElementType;
import io.v.vdl.VdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class VdlElementType extends IElementType {
    public VdlElementType(@NotNull @NonNls String debugName) {
        super(debugName, VdlLanguage.INSTANCE);
    }
}
