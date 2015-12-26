package io.v.vdl.psi;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.ArrayFactory;
import io.v.vdl.psi.impl.VdlMethodDeclarationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class VdlMethodDeclarationStubElementType extends VdlNamedStubElementType<VdlMethodDeclarationStub, VdlMethodDeclaration> {
    public static final VdlMethodDeclaration[] EMPTY_ARRAY = new VdlMethodDeclaration[0];

    public static final ArrayFactory<VdlMethodDeclaration> ARRAY_FACTORY = new ArrayFactory<VdlMethodDeclaration>() {
        @NotNull
        @Override
        public VdlMethodDeclaration[] create(int count) {
            return count == 0 ? EMPTY_ARRAY : new VdlMethodDeclaration[count];
        }
    };

    public VdlMethodDeclarationStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlMethodDeclaration createPsi(@NotNull VdlMethodDeclarationStub stub) {
        return new VdlMethodDeclarationImpl(stub, this);
    }

    @Nullable
    @Override
    public VdlMethodDeclarationStub createStub(@NotNull VdlMethodDeclaration psi, StubElement parentStub) {
        return new VdlMethodDeclarationStub(parentStub, this, psi.getName(), psi.isPublic(), calcTypeText(psi));
    }

    @Override
    public void serialize(@NotNull VdlMethodDeclarationStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeBoolean(stub.isPublic());
        dataStream.writeName(stub.getTypeName());
    }

    @NotNull
    @Override
    public VdlMethodDeclarationStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlMethodDeclarationStub(parentStub, this, dataStream.readName(), dataStream.readBoolean(), dataStream.readName());
    }

    @Override
    public void indexStub(@NotNull VdlMethodDeclarationStub stub, @NotNull IndexSink sink) {
        super.indexStub(stub, sink);
        String typeName = stub.getTypeName();
        if (!StringUtil.isEmpty(typeName)) {
            StubElement parent = stub.getParentStub();
            if (parent instanceof VdlFileStub) {
                String packageName = ((VdlFileStub)parent).getPackageName();
                if (!StringUtil.isEmpty(typeName)) {
                    sink.occurrence(VdlMethodIndex.KEY, packageName + "." + typeName);
                }
            }
        }
    }

    @Nullable
    public static String calcTypeText(@NotNull VdlMethodDeclaration psi) {
        VdlTypeReferenceExpression reference = VdlPsiImplUtil.getTypeReference(psi.getReceiver().getType());
        return reference != null ? reference.getIdentifier().getText() : null;
    }
}
