// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ArrayFactory;
import io.v.vdl.psi.impl.VdlImportSpecImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class VdlImportSpecStubElementType extends VdlNamedStubElementType<VdlImportSpecStub, VdlImportSpec> {
    public static final VdlImportSpec[] EMPTY_ARRAY = new VdlImportSpec[0];
    public static final ArrayFactory<VdlImportSpec> ARRAY_FACTORY = new ArrayFactory<VdlImportSpec>() {
        @NotNull
        @Override
        public VdlImportSpec[] create(int count) {
            return count == 0 ? EMPTY_ARRAY : new VdlImportSpec[count];
        }
    };

    public VdlImportSpecStubElementType(@NotNull String name) {
        super(name);
    }

    @NotNull
    @Override
    public VdlImportSpec createPsi(@NotNull VdlImportSpecStub stub) {
        return new VdlImportSpecImpl(stub, this);
    }

    @NotNull
    @Override
    public VdlImportSpecStub createStub(@NotNull VdlImportSpec psi, StubElement parentStub) {
        return new VdlImportSpecStub(parentStub, this, psi.getAlias(), psi.getPath(), psi.isDot());
    }

    @Override
    public void serialize(@NotNull VdlImportSpecStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeUTFFast(StringUtil.notNullize(stub.getAlias()));
        dataStream.writeUTFFast(stub.getPath());
        dataStream.writeBoolean(stub.isDot());
    }

    @NotNull
    @Override
    public VdlImportSpecStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new VdlImportSpecStub(parentStub, this, StringUtil.nullize(dataStream.readUTFFast()),
                dataStream.readUTFFast(), dataStream.readBoolean());
    }
}
