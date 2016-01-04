// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.Nullable;

public class StubWithText<T extends PsiElement> extends StubBase<T> implements TextHolder {
    @Nullable
    private final StringRef myText;

    protected StubWithText(StubElement parent, IStubElementType elementType, @Nullable StringRef ref) {
        super(parent, elementType);
        myText = ref;
    }

    @Nullable
    public String getText() {
        return myText == null ? null : myText.getString();
    }

}
