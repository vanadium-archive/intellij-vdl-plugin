// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.scope.BaseScopeProcessor;

public abstract class VdlScopeProcessor extends BaseScopeProcessor {
    public boolean isCompletion() {
        return false;
    }
}
