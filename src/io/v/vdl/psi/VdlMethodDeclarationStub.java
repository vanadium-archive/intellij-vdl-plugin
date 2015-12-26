package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.Nullable;

public class VdlMethodDeclarationStub extends VdlNamedStub<VdlMethodDeclaration> {
    private final StringRef myTypeName;

    public VdlMethodDeclarationStub(StubElement parent, IStubElementType elementType, StringRef name, boolean isPublic, StringRef typeName) {
        super(parent, elementType, name, isPublic);
        myTypeName = typeName;
    }

    public VdlMethodDeclarationStub(StubElement parent, IStubElementType elementType, String name, boolean isPublic, String typeName) {
        super(parent, elementType, name, isPublic);
        myTypeName = StringRef.fromString(typeName);
    }

    @Nullable
    public String getTypeName() {
        return myTypeName == null ? null : myTypeName.getString();
    }
}
