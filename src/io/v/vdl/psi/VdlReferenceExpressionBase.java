// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface VdlReferenceExpressionBase extends VdlCompositeElement {
    @NotNull
    PsiElement getIdentifier();

    @Nullable
    VdlReferenceExpressionBase getQualifier();
}
