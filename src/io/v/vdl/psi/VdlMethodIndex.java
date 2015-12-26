package io.v.vdl.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.util.Processor;
import io.v.vdl.VdlFileElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class VdlMethodIndex extends StringStubIndexExtension<VdlMethodDeclaration>  {
    public static final StubIndexKey<String, VdlMethodDeclaration> KEY = StubIndexKey.createIndexKey("go.method");

    @Override
    public int getVersion() {
        return VdlFileElementType.VERSION;
    }

    @NotNull
    @Override
    public StubIndexKey<String, VdlMethodDeclaration> getKey() {
        return KEY;
    }

    public static Collection<VdlMethodDeclaration> find(@NotNull String name, @NotNull Project project, GlobalSearchScope scope) {
        return StubIndex.getElements(KEY, name, project, scope, VdlMethodDeclaration.class);
    }

    public static boolean process(@NotNull String name,
                                  @NotNull Project project,
                                  @Nullable GlobalSearchScope scope,
                                  @NotNull Processor<VdlMethodDeclaration> processor) {
        return StubIndex.getInstance().processElements(KEY, name, project, scope, VdlMethodDeclaration.class, processor);
    }
}
