// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.util.PsiTreeUtil;
import io.v.vdl.VdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public abstract class VdlStubElementType<S extends StubBase<T>, T extends VdlCompositeElement> extends IStubElementType<S, T> {
    public VdlStubElementType(@NonNls @NotNull String debugName) {
        super(debugName, VdlLanguage.INSTANCE);
    }

    @NotNull
    public String getExternalId() {
        return "vdl." + super.toString();
    }

    public void indexStub(@NotNull S stub, @NotNull IndexSink sink) {
    }

    @Override
    public boolean shouldCreateStub(ASTNode node) {
        return super.shouldCreateStub(node) && PsiTreeUtil.getParentOfType(node.getPsi(), VdlBlock.class) == null;
    }
}
