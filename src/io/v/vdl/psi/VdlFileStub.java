package io.v.vdl.psi;

import com.intellij.psi.stubs.PsiFileStubImpl;

public class VdlFileStub extends PsiFileStubImpl<VdlFile> {
    public VdlFileStub(VdlFile file) {
        super(file);
    }
}
