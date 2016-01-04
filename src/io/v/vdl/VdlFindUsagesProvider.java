// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.lang.HelpID;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.ElementDescriptionUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.usageView.UsageViewLongNameLocation;
import com.intellij.usageView.UsageViewShortNameLocation;
import io.v.vdl.psi.VdlAnonymousFieldDefinition;
import io.v.vdl.psi.VdlConstDeclaration;
import io.v.vdl.psi.VdlConstDefinition;
import io.v.vdl.psi.VdlFieldDefinition;
import io.v.vdl.psi.VdlFunctionDeclaration;
import io.v.vdl.psi.VdlImportDeclaration;
import io.v.vdl.psi.VdlImportSpec;
import io.v.vdl.psi.VdlLabelDefinition;
import io.v.vdl.psi.VdlMethodSpec;
import io.v.vdl.psi.VdlNamedElement;
import io.v.vdl.psi.VdlPackageClause;
import io.v.vdl.psi.VdlParamDefinition;
import io.v.vdl.psi.VdlStatement;
import io.v.vdl.psi.VdlTypeDeclaration;
import io.v.vdl.psi.VdlTypeSpec;
import io.v.vdl.psi.VdlTypes;
import io.v.vdl.psi.VdlVarDeclaration;
import io.v.vdl.psi.VdlVarDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VdlFindUsagesProvider implements FindUsagesProvider {
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new VdlLexer(), TokenSet.create(VdlTypes.IDENTIFIER),
                VdlParserDefinition.COMMENTS, VdlParserDefinition.STRING_LITERALS);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement element) {
        if (element instanceof VdlImportSpec) {
            VdlImportSpec importSpec = (VdlImportSpec)element;
            return importSpec.getAlias() != null && !importSpec.isDot();
        }
        return element instanceof VdlNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return HelpID.FIND_OTHER_USAGES;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof VdlFunctionDeclaration) return "function";
        if (element instanceof VdlConstDefinition || element instanceof VdlConstDeclaration) return "constant";
        if (element instanceof VdlVarDefinition || element instanceof VdlVarDeclaration) return "variable";
        if (element instanceof VdlParamDefinition) return "parameter";
        if (element instanceof VdlFieldDefinition) return "field";
        if (element instanceof VdlAnonymousFieldDefinition) return "anonymous field";
        if (element instanceof VdlTypeSpec || element instanceof VdlTypeDeclaration) return "type";
        if (element instanceof VdlImportDeclaration) return "import";
        if (element instanceof VdlImportSpec) return "import alias";
        if (element instanceof VdlMethodSpec) return "method specification";
        if (element instanceof VdlLabelDefinition) return "label";
        if (element instanceof VdlPackageClause) return "package statement";

        // should be last
        if (element instanceof VdlStatement) return "statement";
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        return ElementDescriptionUtil.getElementDescription(element, UsageViewLongNameLocation.INSTANCE);
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return ElementDescriptionUtil.getElementDescription(element, UsageViewShortNameLocation.INSTANCE);
    }
}