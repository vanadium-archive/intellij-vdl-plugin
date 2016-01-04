// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.NamedStubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;

public abstract class VdlNamedStub<T extends VdlNamedElement> extends NamedStubBase<T> {
    private final boolean myIsPublic;

    public VdlNamedStub(StubElement parent, IStubElementType elementType, StringRef name, boolean isPublic) {
        super(parent, elementType, name);
        myIsPublic = isPublic;
    }

    public VdlNamedStub(StubElement parent, IStubElementType elementType, String name, boolean isPublic) {
        super(parent, elementType, name);
        myIsPublic = isPublic;
    }

    public boolean isPublic() {
        return myIsPublic;
    }

}
