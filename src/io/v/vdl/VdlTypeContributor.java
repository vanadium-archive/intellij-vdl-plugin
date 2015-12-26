package io.v.vdl;

import io.v.vdl.psi.VdlTypeSpec;
import io.v.vdl.psi.VdlTypesIndex;

public class VdlTypeContributor extends VdlGotoContributorBase<VdlTypeSpec> {
    public VdlTypeContributor() {
        super(VdlTypeSpec.class, VdlTypesIndex.KEY);
    }
}
