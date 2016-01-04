// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ResolveUtil {
    public static boolean treeWalkUp(@Nullable PsiElement place, @NotNull PsiScopeProcessor processor) {
        PsiElement lastParent = null;
        PsiElement run = place;
        while (run != null) {
            if (place != run && !run.processDeclarations(processor, ResolveState.initial(), lastParent, place))
                return false;
            lastParent = run;
            run = run.getParent();
        }
        return true;
    }

    public static boolean processChildren(@NotNull PsiElement element,
                                          @NotNull PsiScopeProcessor processor,
                                          @NotNull ResolveState substitutor,
                                          @Nullable PsiElement lastParent,
                                          @NotNull PsiElement place) {
        PsiElement run = lastParent == null ? element.getLastChild() : lastParent.getPrevSibling();
        while (run != null) {
            if (run instanceof VdlCompositeElement && !run.processDeclarations(processor, substitutor, null, place))
                return false;
            run = run.getPrevSibling();
        }
        return true;
    }

    public static boolean processChildrenFromTop(@NotNull PsiElement element,
                                                 @NotNull PsiScopeProcessor processor,
                                                 @NotNull ResolveState substitutor,
                                                 @Nullable PsiElement lastParent,
                                                 @NotNull PsiElement place) {
        PsiElement run = element.getFirstChild();
        while (run != null) {
            if (run instanceof VdlCompositeElement) {
                if (run.isEquivalentTo(lastParent)) return true;
                if (!run.processDeclarations(processor, substitutor, null, place)) return false;
            }
            run = run.getNextSibling();
        }
        return true;
    }

}
