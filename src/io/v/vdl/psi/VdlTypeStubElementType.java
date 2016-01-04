// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public abstract class VdlTypeStubElementType extends VdlStubElementType<VdlTypeStub, VdlType> {
    public VdlTypeStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlTypeStub createStub(@NotNull VdlType psi, StubElement parentStub) {
        return new VdlTypeStub(parentStub, this, psi.getText());
    }

    @Override
    public void serialize(@NotNull VdlTypeStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getText());
    }

    @NotNull
    @Override
    public VdlTypeStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlTypeStub(parentStub, this, dataStream.readName());
    }
}
