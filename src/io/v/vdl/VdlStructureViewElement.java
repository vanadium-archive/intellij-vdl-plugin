// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import io.v.vdl.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
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
        ItemPresentation result = null;
        if (element.isValid() && element instanceof NavigationItem) {
            result = ((NavigationItem) element).getPresentation();
        }

        if (result == null) {
            result = new ItemPresentation() {
                @Nullable
                @Override
                public String getPresentableText() {
                    return null;
                }

                @Nullable
                @Override
                public String getLocationString() {
                    return null;
                }

                @Nullable
                @Override
                public Icon getIcon(boolean b) {
                    return null;
                }
            };
        }
        return result;
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        List<TreeElement> result = new ArrayList<TreeElement>();

        if (element instanceof VdlFile) {
            for (VdlTypeSpec typeSpec : ((VdlFile) element).getTypes()) {
                result.add(new VdlStructureViewElement(typeSpec));
            }
        } else if (element instanceof VdlTypeSpec) {
            VdlType type = ((VdlTypeSpec) element).getSpecType().getType();
            if (type instanceof VdlInterfaceType) {
                for (VdlMethodSpec spec : ((VdlInterfaceType)type).getMethodSpecList()) {
                    result.add(new VdlStructureViewElement(spec));
                }
            } else if (type instanceof VdlStructOrUnionType) {
                for (VdlFieldDeclaration decl : ((VdlStructOrUnionType) type).getFieldDeclarationList()) {
                    for (VdlFieldDefinition defn : decl.getFieldDefinitionList()) {
                        result.add(new VdlStructureViewElement(defn));
                    }
                }
            }
        }
        return result.toArray(new TreeElement[result.size()]);
    }
}
