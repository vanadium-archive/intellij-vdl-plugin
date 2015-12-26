package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;

public class VdlTypeStub extends StubWithText<VdlType> {
    public VdlTypeStub(StubElement parent, IStubElementType elementType, StringRef ref) {
        super(parent, elementType, ref);
    }

    public VdlTypeStub(StubElement parent, IStubElementType elementType, String text) {
        this(parent, elementType, StringRef.fromString(text));
    }
}
