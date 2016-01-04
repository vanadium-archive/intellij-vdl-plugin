package io.v.vdl.psi;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import io.v.vdl.psi.impl.VdlAnonymousFieldDefinitionImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class VdlAnonymousFieldDefinitionStubElementType extends VdlNamedStubElementType<VdlAnonymousFieldDefinitionStub, VdlAnonymousFieldDefinition> {
    public VdlAnonymousFieldDefinitionStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlAnonymousFieldDefinition createPsi(@NotNull VdlAnonymousFieldDefinitionStub stub) {
        return new VdlAnonymousFieldDefinitionImpl(stub, this);
    }

    @NotNull
    @Override
    public VdlAnonymousFieldDefinitionStub createStub(@NotNull VdlAnonymousFieldDefinition psi, StubElement parentStub) {
        return new VdlAnonymousFieldDefinitionStub(parentStub, this, psi.getName(), psi.isPublic());
    }

    @Override
    public void serialize(@NotNull VdlAnonymousFieldDefinitionStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeBoolean(stub.isPublic());
    }

    @NotNull
    @Override
    public VdlAnonymousFieldDefinitionStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlAnonymousFieldDefinitionStub(parentStub, this, dataStream.readName(), dataStream.readBoolean());
    }
}
