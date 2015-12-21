package io.v.vdl.psi;

import com.intellij.psi.tree.IElementType;
import io.v.vdl.VdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class VdlCompositeElementType extends IElementType {
    public VdlCompositeElementType(@NotNull @NonNls String debugName) {
        super(debugName, VdlLanguage.INSTANCE);
    }
}
