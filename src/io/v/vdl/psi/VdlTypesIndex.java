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

public class VdlTypesIndex extends StringStubIndexExtension<VdlTypeSpec> {
    public static final StubIndexKey<String, VdlTypeSpec> KEY = StubIndexKey.createIndexKey("vdl.type.name");

    @Override
    public int getVersion() {
        return VdlFileElementType.VERSION;
    }

    @NotNull
    @Override
    public StubIndexKey<String, VdlTypeSpec> getKey() {
        return KEY;
    }

    @NotNull
    public static Collection<VdlTypeSpec> find(@NotNull String name, @NotNull Project project, GlobalSearchScope scope) {
        return StubIndex.getElements(KEY, name, project, scope, VdlTypeSpec.class);
    }
}
