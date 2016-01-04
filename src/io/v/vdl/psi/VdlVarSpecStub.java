// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;

public class VdlVarSpecStub extends StubBase<VdlVarSpec> {
    public VdlVarSpecStub(StubElement parent, IStubElementType elementType) {
        super(parent, elementType);
    }
}
