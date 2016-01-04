// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class VdlStubbedElementImpl<T extends StubBase<?>> extends StubBasedPsiElementBase<T> implements VdlCompositeElement {
    public VdlStubbedElementImpl(@NotNull T stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public VdlStubbedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return getNode().getElementType().toString();
    }

    @Nullable
    protected <C, S> C findChildByClass(Class<C> c, Class<S> s) {
        T stub = getStub();
        if (stub != null) {
            for (StubElement stubElement : stub.getChildrenStubs()) {
                if (s.isInstance(stubElement)) {
                    //noinspection unchecked
                    return (C)stubElement.getPsi();
                }
            }
            return null;
        }
        return super.findChildByClass(c);
    }

    @Nullable
    protected <C, S> C findNotNullChildByClass(Class<C> c, Class<S> s) {
        return notNullChild(findChildByClass(c, s));
    }

    @NotNull
    protected <C extends PsiElement, S> List<C> findChildrenByClass(Class<C> c, Class<S> s) {
        T stub = getStub();
        if (stub != null) {
            List<C> result = new SmartList<C>();
            for (StubElement stubElement : stub.getChildrenStubs()) {
                if (s.isInstance(stubElement)) {
                    //noinspection unchecked
                    result.add((C)stubElement.getPsi());
                }
            }
            return result;
        }
        return PsiTreeUtil.getChildrenOfTypeAsList(this, c);
    }

    @NotNull
    @Override
    public VdlFile getContainingFile() {
        return (VdlFile)super.getContainingFile();
    }

    @Override
    public boolean shouldGoDeeper() {
        return true;
    }
}
