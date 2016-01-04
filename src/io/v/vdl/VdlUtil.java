// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.CachedValue;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.util.containers.ContainerUtil;
import io.v.vdl.psi.VdlFile;
import io.v.vdl.psi.VdlImportSpec;
import io.v.vdl.psi.VdlLabelDefinition;
import io.v.vdl.psi.VdlLabelRef;
import io.v.vdl.psi.VdlNamedElement;
import io.v.vdl.psi.VdlReceiverType;
import io.v.vdl.psi.VdlReferenceExpressionBase;
import io.v.vdl.psi.VdlTypeReferenceExpression;
import io.v.vdl.psi.VdlTypeSpec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;

public class VdlUtil {
    private static final Key<CachedValue<Collection<String>>> PACKAGE_CACHE_KEY = Key.create("packages_cache");

    public static boolean couldBeReferenceTo(@NotNull PsiElement definition, @NotNull PsiElement reference) {
        if (definition instanceof PsiDirectory && reference instanceof VdlReferenceExpressionBase) return true;
        if (reference instanceof VdlLabelRef && !(definition instanceof VdlLabelDefinition)) return false;
        if (reference instanceof VdlTypeReferenceExpression &&
                !(reference.getParent() instanceof VdlReceiverType) &&
                !(definition instanceof VdlTypeSpec || definition instanceof VdlImportSpec)) {
            return false;
        }

        PsiFile definitionFile = definition.getContainingFile();
        PsiFile referenceFile = reference.getContainingFile();
        if (!(definitionFile instanceof VdlFile) || !(referenceFile instanceof VdlFile)) {
            return false;
        }

        boolean inSameFile = definitionFile.isEquivalentTo(referenceFile);
        if (!inSameFile) {
            String referencePackage = ((VdlFile)referenceFile).getPackageName();
            String definitionPackage = ((VdlFile)definitionFile).getPackageName();
            boolean inSamePackage = referencePackage != null && referencePackage.equals(definitionPackage);

            if (!inSamePackage) {
                if (reference instanceof VdlNamedElement && !((VdlNamedElement)reference).isPublic()) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    public static Collection<String> getAllPackagesInDirectory(@Nullable final PsiDirectory dir, final boolean trimTestSuffices) {
        if (dir == null) return Collections.emptyList();
        return CachedValuesManager.getManager(dir.getProject()).getCachedValue(dir, PACKAGE_CACHE_KEY, new CachedValueProvider<Collection<String>>() {
            @Nullable
            @Override
            public Result<Collection<String>> compute() {
                Collection<String> set = ContainerUtil.newLinkedHashSet();
                for (PsiFile file : dir.getFiles()) {
                    if (file instanceof VdlFile) {
                        String name = ((VdlFile)file).getPackageName();
                        if (StringUtil.isNotEmpty(name)) {
                            set.add(name);
                        }
                    }
                }
                return Result.create(set, dir);
            }
        }, false);
    }

}
