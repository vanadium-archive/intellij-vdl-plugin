package io.v.vdl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import io.v.vdl.VdlFileType;
import io.v.vdl.VdlLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class VdlFile extends PsiFileBase {
    public VdlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, VdlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return VdlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "VDL file";
    }
}
