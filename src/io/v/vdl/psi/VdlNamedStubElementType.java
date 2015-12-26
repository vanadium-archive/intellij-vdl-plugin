package io.v.vdl.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubIndexKey;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;

public abstract class VdlNamedStubElementType<S extends VdlNamedStub<T>, T extends VdlNamedElement> extends VdlStubElementType<S, T> {
    public VdlNamedStubElementType(@NonNls @NotNull String debugName) {
        super(debugName);
    }

    @Override
    public boolean shouldCreateStub(@NotNull ASTNode node) {
        PsiElement psi = node.getPsi();
        return super.shouldCreateStub(node) && psi instanceof VdlNamedElement && StringUtil.isNotEmpty(((VdlNamedElement)psi).getName());
    }

    public void indexStub(@NotNull S stub, @NotNull IndexSink sink) {
        String name = stub.getName();
        if (shouldIndex() && StringUtil.isNotEmpty(name)) {
            String packageName = null;
            StubElement parent = stub.getParentStub();
            while (parent != null) {
                if (parent instanceof VdlFileStub) {
                    packageName = ((VdlFileStub)parent).getPackageName();
                    break;
                }
                parent = parent.getParentStub();
            }

            String indexingName = StringUtil.isNotEmpty(packageName) ? packageName + "." + name : name;
            if (stub.isPublic()) {
                sink.occurrence(VdlAllPublicNamesIndex.ALL_PUBLIC_NAMES, indexingName);
            }
            else {
                sink.occurrence(VdlAllPrivateNamesIndex.ALL_PRIVATE_NAMES, indexingName);
            }
            for (StubIndexKey<String, ? extends VdlNamedElement> key : getExtraIndexKeys()) {
                sink.occurrence(key, name);
            }
        }
    }

    protected boolean shouldIndex() {
        return true;
    }

    @NotNull
    protected Collection<StubIndexKey<String, ? extends VdlNamedElement>> getExtraIndexKeys() {
        return Collections.emptyList();
    }

}
