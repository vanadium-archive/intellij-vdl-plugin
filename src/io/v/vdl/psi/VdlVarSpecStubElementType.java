package io.v.vdl.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.ArrayFactory;
import io.v.vdl.psi.impl.VdlVarSpecImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class VdlVarSpecStubElementType extends VdlStubElementType<VdlVarSpecStub, VdlVarSpec> {
    public static final VdlVarSpec[] EMPTY_ARRAY = new VdlVarSpec[0];

    public static final ArrayFactory<VdlVarSpec> ARRAY_FACTORY = new ArrayFactory<VdlVarSpec>() {
        @NotNull
        @Override
        public VdlVarSpec[] create(int count) {
            return count == 0 ? EMPTY_ARRAY : new VdlVarSpec[count];
        }
    };

    public VdlVarSpecStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlVarSpec createPsi(@NotNull VdlVarSpecStub stub) {
        return new VdlVarSpecImpl(stub, this);
    }

    @NotNull
    @Override
    public VdlVarSpecStub createStub(@NotNull VdlVarSpec psi, StubElement parentStub) {
        return new VdlVarSpecStub(parentStub, this);
    }

    @Override
    public boolean shouldCreateStub(ASTNode node) {
        return super.shouldCreateStub(node) && node.getElementType() == VdlTypes.VAR_SPEC;
    }

    @Override
    public void serialize(@NotNull VdlVarSpecStub stub, @NotNull StubOutputStream dataStream) throws IOException {
    }

    @NotNull
    @Override
    public VdlVarSpecStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlVarSpecStub(parentStub, this);
    }
}
