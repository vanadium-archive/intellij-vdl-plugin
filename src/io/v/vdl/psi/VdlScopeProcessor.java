package io.v.vdl.psi;

import com.intellij.psi.scope.BaseScopeProcessor;

public abstract class VdlScopeProcessor extends BaseScopeProcessor {
    public boolean isCompletion() {
        return false;
    }
}
