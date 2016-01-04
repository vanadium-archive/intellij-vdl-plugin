package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;

public class VdlVarSpecStub extends StubBase<VdlVarSpec> {
    public VdlVarSpecStub(StubElement parent, IStubElementType elementType) {
        super(parent, elementType);
    }
}
