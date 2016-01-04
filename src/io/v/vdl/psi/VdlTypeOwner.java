// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.ResolveState;
import org.jetbrains.annotations.Nullable;

public interface VdlTypeOwner extends VdlCompositeElement {
    @Nullable
    VdlType getVdlType(@Nullable ResolveState context);
}
