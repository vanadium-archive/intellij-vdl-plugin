package io.v.vdl.psi;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ReflectionUtil;
import org.jetbrains.annotations.NotNull;

public class VdlStubElementTypeFactory {
    public static IElementType factory(String name) {
        if (name.equals("METHOD_SPEC")) return new VdlMethodSpecStubElementType(name);
        if (name.equals("IMPORT_SPEC")) return new VdlImportSpecStubElementType(name);
        if (name.equals("TYPE_SPEC")) return new VdlTypeSpecStubElementType(name);
        if (name.equals("METHOD_DECLARATION")) return new VdlMethodDeclarationStubElementType(name);
        throw new RuntimeException("Unknown element type: " + name);

    }
}
