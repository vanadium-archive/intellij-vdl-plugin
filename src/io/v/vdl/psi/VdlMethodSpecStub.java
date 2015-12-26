package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;

public class VdlMethodSpecStub extends VdlNamedStub<VdlMethodSpec> {
    private final int myArity;

    public VdlMethodSpecStub(StubElement parent, IStubElementType elementType, StringRef name, boolean isPublic, int arity) {
        super(parent, elementType, name, isPublic);
        myArity = arity;
    }

    public VdlMethodSpecStub(StubElement parent, IStubElementType elementType, String name, boolean isPublic, int arity) {
        super(parent, elementType, name, isPublic);
        myArity = arity;
    }

    public int getArity() {
        return myArity;
    }

}
