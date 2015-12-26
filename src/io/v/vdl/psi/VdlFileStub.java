// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.PsiFileStubImpl;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VdlFileStub extends PsiFileStubImpl<VdlFile> {
    private final StringRef myPackageName;

    public VdlFileStub(@NotNull VdlFile file) {
        this(file, StringRef.fromNullableString(file.getPackageName()));
    }

    public VdlFileStub(@Nullable VdlFile file, StringRef packageName) {
        super(file);
        myPackageName = packageName;
    }

    @Nullable
    public String getPackageName() {
        return myPackageName.getString();
    }
}
