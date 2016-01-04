package io.v.vdl.psi;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.ElementBase;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.RowIcon;
import com.intellij.usageView.UsageViewUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import io.v.vdl.VdlIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class VdlNamedElementImpl<T extends VdlNamedStub<?>> extends VdlStubbedElementImpl<T> implements VdlCompositeElement, VdlNamedElement {

    public VdlNamedElementImpl(@NotNull T stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public VdlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    public boolean isPublic() {
        T stub = getStub();
        return stub != null ? stub.isPublic() : StringUtil.isCapitalized(getName());
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return getIdentifier();
    }

    @Nullable
    @Override
    public String getName() {
        T stub = getStub();
        if (stub != null) {
            return stub.getName();
        }
        PsiElement identifier = getIdentifier();
        return identifier != null ? identifier.getText() : null;
    }

    @Nullable
    @Override
    public String getQualifiedName() {
        String name = getName();
        if (name == null) return null;
        String packageName = getContainingFile().getPackageName();
        return StringUtil.isNotEmpty(packageName) ? packageName + "." + name : name;
    }

    @Override
    public int getTextOffset() {
        PsiElement identifier = getIdentifier();
        return identifier != null ? identifier.getTextOffset() : super.getTextOffset();
    }

    @NotNull
    @Override
    public PsiElement setName(@NonNls @NotNull String newName) throws IncorrectOperationException {
        PsiElement identifier = getIdentifier();
        if (identifier != null) {
            identifier.replace(VdlElementFactory.createIdentifierFromText(getProject(), newName));
        }
        return this;
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        Icon icon = null;
        if (this instanceof VdlFunctionDeclaration) icon = VdlIcons.FUNCTION;
        else if (this instanceof VdlTypeSpec) icon = VdlIcons.TYPE;
        else if (this instanceof VdlVarDefinition) icon = VdlIcons.VARIABLE;
        else if (this instanceof VdlConstDefinition) icon = VdlIcons.CONSTANT;
        else if (this instanceof VdlFieldDefinition) icon = VdlIcons.FIELD;
        else if (this instanceof VdlMethodSpec) icon = VdlIcons.METHOD;
        else if (this instanceof VdlAnonymousFieldDefinition) icon = VdlIcons.FIELD;
        else if (this instanceof VdlParamDefinition) icon = VdlIcons.PARAMETER;
        if (icon != null) {
            if ((flags & Iconable.ICON_FLAG_VISIBILITY) != 0) {
                RowIcon rowIcon = ElementBase.createLayeredIcon(this, icon, flags);
                rowIcon.setIcon(isPublic() ? PlatformIcons.PUBLIC_ICON : PlatformIcons.PRIVATE_ICON, 1);
                return rowIcon;
            }
            return icon;
        }
        return super.getIcon(flags);
    }

    @Override
    public ItemPresentation getPresentation() {
        String text = UsageViewUtil.createNodeText(this);
        if (text != null) {
            return new ItemPresentation() {
                @Nullable
                @Override
                public String getPresentableText() {
                    return getName();
                }

                @Nullable
                @Override
                public String getLocationString() {
                    return "in " + getContainingFile().getName();
                }

                @Nullable
                @Override
                public Icon getIcon(boolean b) {
                    return VdlNamedElementImpl.this.getIcon(Iconable.ICON_FLAG_VISIBILITY);
                }
            };
        }
        return super.getPresentation();
    }

    @Override
    public boolean shouldGoDeeper() {
        return true;
    }

    @Nullable
    @Override
    public VdlType findSiblingType() {
        T stub = getStub();
        if (stub != null) {
            PsiElement parent = getParentByStub();
            // todo: cast is weird
            return parent instanceof VdlStubbedElementImpl ?
                    (VdlType)((VdlStubbedElementImpl)parent).findChildByClass(VdlType.class, VdlTypeStub.class) :
                    null;
        }
        return PsiTreeUtil.getNextSiblingOfType(this, VdlType.class);
    }
}
