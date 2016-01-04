// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import io.v.vdl.psi.VdlTypeSpec;
import io.v.vdl.psi.VdlTypesIndex;

public class VdlTypeContributor extends VdlGotoContributorBase<VdlTypeSpec> {
    public VdlTypeContributor() {
        super(VdlTypeSpec.class, VdlTypesIndex.KEY);
    }
}
