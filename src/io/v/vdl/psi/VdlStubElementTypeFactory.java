// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ReflectionUtil;
import com.intellij.util.containers.HashMap;
import io.v.vdl.psi.impl.VdlArrayOrSliceTypeImpl;
import io.v.vdl.psi.impl.VdlChannelTypeImpl;
import io.v.vdl.psi.impl.VdlEnumTypeImpl;
import io.v.vdl.psi.impl.VdlFunctionTypeImpl;
import io.v.vdl.psi.impl.VdlInterfaceTypeImpl;
import io.v.vdl.psi.impl.VdlMapTypeImpl;
import io.v.vdl.psi.impl.VdlParTypeImpl;
import io.v.vdl.psi.impl.VdlPointerTypeImpl;
import io.v.vdl.psi.impl.VdlReceiverTypeImpl;
import io.v.vdl.psi.impl.VdlSetTypeImpl;
import io.v.vdl.psi.impl.VdlSpecTypeImpl;
import io.v.vdl.psi.impl.VdlStructOrUnionTypeImpl;
import io.v.vdl.psi.impl.VdlTypeImpl;
import io.v.vdl.psi.impl.VdlTypeListImpl;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class VdlStubElementTypeFactory {
    private static Map<String, Class> TYPES = new HashMap<String, Class>();

    static {
        TYPES.put("ARRAY_OR_SLICE_TYPE", VdlArrayOrSliceTypeImpl.class);
        TYPES.put("CHANNEL_TYPE", VdlChannelTypeImpl.class);
        TYPES.put("FUNCTION_TYPE", VdlFunctionTypeImpl.class);
        TYPES.put("INTERFACE_TYPE", VdlInterfaceTypeImpl.class);
        TYPES.put("MAP_TYPE", VdlMapTypeImpl.class);
        TYPES.put("POINTER_TYPE", VdlPointerTypeImpl.class);
        TYPES.put("RECEIVER_TYPE", VdlReceiverTypeImpl.class);
        TYPES.put("STRUCT_OR_UNION_TYPE", VdlStructOrUnionTypeImpl.class);
        TYPES.put("TYPE", VdlTypeImpl.class);
        TYPES.put("PAR_TYPE", VdlParTypeImpl.class);
        TYPES.put("SPEC_TYPE", VdlSpecTypeImpl.class);
        TYPES.put("TYPE_LIST", VdlTypeListImpl.class);
        TYPES.put("ENUM_TYPE", VdlEnumTypeImpl.class);
        TYPES.put("SET_TYPE", VdlSetTypeImpl.class);
    }

    public static IElementType factory(String name) {
        if (name.equals("METHOD_SPEC")) return new VdlMethodSpecStubElementType(name);
        if (name.equals("IMPORT_SPEC")) return new VdlImportSpecStubElementType(name);
        if (name.equals("TYPE_SPEC")) return new VdlTypeSpecStubElementType(name);
        if (name.equals("FIELD_DEFINITION")) return new VdlFieldDefinitionStubElementType(name);
        if (name.equals("VAR_SPEC")) return new VdlVarSpecStubElementType(name);
        if (name.equals("VAR_DEFINITION")) return new VdlVarDefinitionStubElementType(name);
        if (name.equals("ANONYMOUS_FIELD_DEFINITION")) return new VdlAnonymousFieldDefinitionStubElementType(name);

        final Class c = TYPES.get(name);
        if (c != null) {
            return new VdlTypeStubElementType(name) {
                @NotNull
                @Override
                public VdlType createPsi(@NotNull VdlTypeStub stub) {
                    try {
                        //noinspection unchecked
                        return (VdlType) ReflectionUtil.createInstance(c.getConstructor(stub.getClass(), IStubElementType.class), stub, this);
                    }
                    catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        }

        throw new RuntimeException("Unknown element type: " + name);
    }
}
