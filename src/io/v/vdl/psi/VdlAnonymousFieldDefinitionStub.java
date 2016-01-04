// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;

public class VdlAnonymousFieldDefinitionStub extends VdlNamedStub<VdlAnonymousFieldDefinition> {
    public VdlAnonymousFieldDefinitionStub(StubElement parent, IStubElementType elementType, StringRef name, boolean isPublic) {
        super(parent, elementType, name, isPublic);
    }

    public VdlAnonymousFieldDefinitionStub(StubElement parent, IStubElementType elementType, String name, boolean isPublic) {
        super(parent, elementType, name, isPublic);
    }
}