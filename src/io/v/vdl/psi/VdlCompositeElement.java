// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.PsiElement;

public interface VdlCompositeElement extends PsiElement {
    boolean shouldGoDeeper();
}
