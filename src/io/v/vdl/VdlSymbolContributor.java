// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import io.v.vdl.psi.VdlAllPrivateNamesIndex;
import io.v.vdl.psi.VdlAllPublicNamesIndex;
import io.v.vdl.psi.VdlNamedElement;

public class VdlSymbolContributor extends VdlGotoContributorBase<VdlNamedElement> {
    public VdlSymbolContributor() {
        super(VdlNamedElement.class, VdlAllPublicNamesIndex.ALL_PUBLIC_NAMES, VdlAllPrivateNamesIndex.ALL_PRIVATE_NAMES);
    }
}
