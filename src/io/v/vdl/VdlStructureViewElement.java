// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import io.v.vdl.psi.VdlAnonymousFieldDefinition;
import io.v.vdl.psi.VdlFieldDeclaration;
import io.v.vdl.psi.VdlFieldDefinition;
import io.v.vdl.psi.VdlFile;
import io.v.vdl.psi.VdlInterfaceType;
import io.v.vdl.psi.VdlMethodDeclaration;
import io.v.vdl.psi.VdlMethodSpec;
import io.v.vdl.psi.VdlPsiImplUtil;
import io.v.vdl.psi.VdlStructType;
import io.v.vdl.psi.VdlType;
import io.v.vdl.psi.VdlTypeSpec;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VdlStructureViewElement implements StructureViewTreeElement {
    private PsiElement element;

    public VdlStructureViewElement(PsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        if (element instanceof NavigationItem) {
            ((NavigationItem) element).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return element instanceof NavigationItem && ((NavigationItem) element).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element instanceof NavigationItem && ((NavigationItem) element).canNavigateToSource();
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return element instanceof NavigationItem ? ((NavigationItem) element).getPresentation() : null;
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        List<TreeElement> result = new ArrayList<TreeElement>();

        if (element instanceof VdlFile) {
            for (VdlTypeSpec typeSpec : ((VdlFile) element).getTypes()) {
                result.add(new VdlStructureViewElement(typeSpec));
            }
        }
        return result.toArray(new TreeElement[result.size()]);
    }
}
