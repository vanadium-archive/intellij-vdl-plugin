package io.v.vdl.psi;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.ArrayFactory;
import com.intellij.util.containers.ContainerUtil;
import io.v.vdl.psi.impl.VdlTypeSpecImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Collection;

public class VdlTypeSpecStubElementType extends VdlNamedStubElementType<VdlTypeSpecStub, VdlTypeSpec> {
    public static final VdlTypeSpec[] EMPTY_ARRAY = new VdlTypeSpec[0];

    public static final ArrayFactory<VdlTypeSpec> ARRAY_FACTORY = new ArrayFactory<VdlTypeSpec>() {
        @NotNull
        @Override
        public VdlTypeSpec[] create(int count) {
            return count == 0 ? EMPTY_ARRAY : new VdlTypeSpec[count];
        }
    };

    public VdlTypeSpecStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlTypeSpec createPsi(@NotNull VdlTypeSpecStub stub) {
        return new VdlTypeSpecImpl(stub, this);
    }

    @NotNull
    @Override
    public VdlTypeSpecStub createStub(@NotNull VdlTypeSpec psi, StubElement parentStub) {
        return new VdlTypeSpecStub(parentStub, this, psi.getName(), psi.isPublic());
    }

    @Override
    public void serialize(@NotNull VdlTypeSpecStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeBoolean(stub.isPublic());
    }

    @NotNull
    @Override
    public VdlTypeSpecStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlTypeSpecStub(parentStub, this, dataStream.readName(), dataStream.readBoolean());
    }

    @NotNull
    @Override
    protected Collection<StubIndexKey<String, ? extends VdlNamedElement>> getExtraIndexKeys() {
        return ContainerUtil.<StubIndexKey<String, ? extends VdlNamedElement>>list(VdlTypesIndex.KEY);
    }
}
