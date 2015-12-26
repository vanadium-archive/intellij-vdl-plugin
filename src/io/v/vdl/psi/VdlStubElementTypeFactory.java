package io.v.vdl.psi;

import com.intellij.psi.tree.IElementType;

public class VdlStubElementTypeFactory {
    public static IElementType factory(String name) {
        if (name.equals("METHOD_SPEC")) return new VdlMethodSpecStubElementType(name);
        if (name.equals("IMPORT_SPEC")) return new VdlImportSpecStubElementType(name);
        if (name.equals("TYPE_SPEC")) return new VdlTypeSpecStubElementType(name);
        throw new RuntimeException("Unknown element type: " + name);
    }
}
