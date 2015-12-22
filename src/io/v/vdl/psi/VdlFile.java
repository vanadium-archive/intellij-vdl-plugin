package io.v.vdl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayFactory;
import io.v.vdl.VdlFileType;
import io.v.vdl.VdlLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<VdlTypeSpec> getTypes() {
        return new ArrayList<VdlTypeSpec>();
    }

    @Nullable
    @Override
    public VdlFileStub getStub() {
        //noinspection unchecked
        return (VdlFileStub)super.getStub();
    }
}
