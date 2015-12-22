// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.PsiFileStubImpl;

public class VdlFileStub extends PsiFileStubImpl<VdlFile> {
    public VdlFileStub(VdlFile file) {
        super(file);
    }
}
