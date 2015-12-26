package io.v.vdl.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface VdlNamedElement extends VdlCompositeElement, PsiNameIdentifierOwner, NavigationItem {
    boolean isPublic();

    @Nullable
    PsiElement getIdentifier();

    @Nullable
    String getQualifiedName();

    @NotNull
    VdlFile getContainingFile();

    @Nullable
    VdlType findSiblingType();

    boolean isBlank();
}
