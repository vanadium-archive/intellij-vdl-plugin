// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.light.LightElement;
import com.intellij.psi.stubs.IStubElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

class VdlLightType<E extends VdlCompositeElement> extends LightElement implements VdlType {
    @NotNull
    protected final E myElement;

    protected VdlLightType(@NotNull E e) {
        super(e.getManager(), e.getLanguage());
        myElement = e;
        setNavigationElement(e);
    }

    @Nullable
    @Override
    public VdlTypeReferenceExpression getTypeReferenceExpression() {
        return null;
    }

    @Override
    public boolean shouldGoDeeper() {
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + myElement + "}";
    }

    @Override
    public IStubElementType getElementType() {
        return null;
    }

    @Override
    public VdlTypeStub getStub() {
        return null;
    }

    @Nullable
    @Override
    public PsiElement getError() {
        return null;
    }

    static class MyGoTypeList extends VdlLightType<VdlCompositeElement> implements VdlTypeList {
        @NotNull private final List<VdlType> myTypes;

        public MyGoTypeList(@NotNull VdlCompositeElement o, @NotNull List<VdlType> types) {
            super(o);
            myTypes = types;
        }

        @NotNull
        @Override
        public List<VdlType> getTypeList() {
            return myTypes;
        }

        @Override
        public String toString() {
            return "MyGoTypeList{myTypes=" + myTypes + '}';
        }
    }

    static class MyFunctionType extends VdlLightType<VdlNamedSignatureOwner> implements VdlFunctionType {
        public MyFunctionType(@NotNull VdlNamedSignatureOwner o) {
            super(o);
        }

        @Nullable
        @Override
        public VdlSignature getSignature() {
            return myElement.getSignature();
        }

        @NotNull
        @Override
        public PsiElement getFunc() {
            return myElement;
        }

        @Override
        public String getText() {
            VdlSignature signature = myElement.getSignature();
            return "func " + (signature != null ? signature.getText() : "<null>");
        }
    }

    static class MyArrayType extends VdlLightType<VdlType> implements VdlArrayOrSliceType {
        protected MyArrayType(VdlType type) {
            super(type);
        }

        @Override
        public String getText() {
            return ("[]" + myElement.getText());
        }

        @Nullable
        @Override
        public VdlExpression getExpression() {
            return null;
        }

        @Nullable
        @Override
        public VdlType getType() {
            return myElement;
        }

        @NotNull
        @Override
        public PsiElement getLbrack() {
            //noinspection ConstantConditions
            return null; // todo: mock?
        }

        @Nullable
        @Override
        public PsiElement getRbrack() {
            return null;
        }

        @Nullable
        @Override
        public PsiElement getTripleDot() {
            return null;
        }
    }

    static class MyVdlTypeList extends VdlLightType<VdlCompositeElement> implements VdlTypeList {
        @NotNull private final List<VdlType> myTypes;

        public MyVdlTypeList(@NotNull VdlCompositeElement o, @NotNull List<VdlType> types) {
            super(o);
            myTypes = types;
        }

        @NotNull
        @Override
        public List<VdlType> getTypeList() {
            return myTypes;
        }

        @Override
        public String toString() {
            return "MyVdlTypeList{myTypes=" + myTypes + '}';
        }
    }
}
