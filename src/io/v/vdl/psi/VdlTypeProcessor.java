// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class VdlTypeProcessor extends VdlScopeProcessorBase {
    public VdlTypeProcessor(@NotNull VdlTypeReferenceExpression origin, boolean completion) {
        super(origin.getIdentifier(), origin, completion);
    }

    @Override
    protected boolean crossOff(@NotNull PsiElement e) {
        return !(e instanceof VdlTypeSpec);
    }
}
