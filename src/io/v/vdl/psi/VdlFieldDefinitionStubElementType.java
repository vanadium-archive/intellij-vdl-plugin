// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import io.v.vdl.psi.impl.VdlFieldDefinitionImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class VdlFieldDefinitionStubElementType extends VdlNamedStubElementType<VdlFieldDefinitionStub, VdlFieldDefinition> {
    public VdlFieldDefinitionStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlFieldDefinition createPsi(@NotNull VdlFieldDefinitionStub stub) {
        return new VdlFieldDefinitionImpl(stub, this);
    }

    @NotNull
    @Override
    public VdlFieldDefinitionStub createStub(@NotNull VdlFieldDefinition psi, StubElement parentStub) {
        return new VdlFieldDefinitionStub(parentStub, this, psi.getName(), psi.isPublic());
    }

    @Override
    public void serialize(@NotNull VdlFieldDefinitionStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeBoolean(stub.isPublic());
    }

    @NotNull
    @Override
    public VdlFieldDefinitionStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlFieldDefinitionStub(parentStub, this, dataStream.readName(), dataStream.readBoolean());
    }
}
