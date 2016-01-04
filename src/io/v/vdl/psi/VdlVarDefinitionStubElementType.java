package io.v.vdl.psi;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.ArrayFactory;
import io.v.vdl.psi.impl.VdlVarDefinitionImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class VdlVarDefinitionStubElementType extends VdlNamedStubElementType<VdlVarDefinitionStub, VdlVarDefinition>  {
    public static final VdlVarDefinition[] EMPTY_ARRAY = new VdlVarDefinition[0];

    public static final ArrayFactory<VdlVarDefinition> ARRAY_FACTORY = new ArrayFactory<VdlVarDefinition>() {
        @NotNull
        @Override
        public VdlVarDefinition[] create(int count) {
            return count == 0 ? EMPTY_ARRAY : new VdlVarDefinition[count];
        }
    };

    public VdlVarDefinitionStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlVarDefinition createPsi(@NotNull VdlVarDefinitionStub stub) {
        return new VdlVarDefinitionImpl(stub, this);
    }

    @NotNull
    @Override
    public VdlVarDefinitionStub createStub(@NotNull VdlVarDefinition psi, StubElement parentStub) {
        return new VdlVarDefinitionStub(parentStub, this, psi.getName(), psi.isPublic());
    }

    @Override
    public void serialize(@NotNull VdlVarDefinitionStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeBoolean(stub.isPublic());
    }

    @NotNull
    @Override
    public VdlVarDefinitionStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlVarDefinitionStub(parentStub, this, dataStream.readName(), dataStream.readBoolean());
    }
}
