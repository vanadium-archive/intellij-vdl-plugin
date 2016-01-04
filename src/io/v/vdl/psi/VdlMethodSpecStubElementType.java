// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import io.v.vdl.psi.impl.VdlMethodSpecImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class VdlMethodSpecStubElementType extends VdlNamedStubElementType<VdlMethodSpecStub, VdlMethodSpec> {
    public VdlMethodSpecStubElementType(@NotNull String name) {
        super(name);
    }

    @Override
    public void indexStub(@NotNull VdlMethodSpecStub stub, @NotNull IndexSink sink) {
        super.indexStub(stub, sink);
        String name = stub.getName();
        int arity = stub.getArity();
        if (name != null && arity >= 0) {
            sink.occurrence(VdlMethodFingerprintIndex.KEY, name + "/" + arity);
        }
    }

    @NotNull
    @Override
    public VdlMethodSpec createPsi(@NotNull VdlMethodSpecStub stub) {
        return new VdlMethodSpecImpl(stub, this);
    }

    @NotNull
    @Override
    public VdlMethodSpecStub createStub(@NotNull VdlMethodSpec psi, StubElement parentStub) {
        int arity = VdlPsiImplUtil.getArity(psi.getSignature());
        return new VdlMethodSpecStub(parentStub, this, psi.getName(), psi.isPublic(), arity);
    }

    @Override
    public void serialize(@NotNull VdlMethodSpecStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeBoolean(stub.isPublic());
        dataStream.writeVarInt(stub.getArity());
    }

    @NotNull
    @Override
    public VdlMethodSpecStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlMethodSpecStub(parentStub, this, dataStream.readName(), dataStream.readBoolean(), dataStream.readVarInt());
    }
}
