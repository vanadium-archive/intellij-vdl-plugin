// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import io.v.vdl.VdlFileElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class VdlMethodFingerprintIndex extends StringStubIndexExtension<VdlMethodSpec> {
    public static final StubIndexKey<String, VdlMethodSpec> KEY = StubIndexKey.createIndexKey("vdl.method.fingerprint");

    @Override
    public int getVersion() {
        return VdlFileElementType.VERSION + 1;
    }

    @NotNull
    @Override
    public StubIndexKey<String, VdlMethodSpec> getKey() {
        return KEY;
    }

    public static Collection<VdlMethodSpec> find(@NotNull String name, @NotNull Project project, GlobalSearchScope scope) {
        return StubIndex.getElements(KEY, name, project, scope, VdlMethodSpec.class);
    }
}
