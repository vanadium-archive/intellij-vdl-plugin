package io.v.vdl.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import io.v.vdl.VdlLanguage;
import org.jetbrains.annotations.NotNull;

public class VdlElementFactory {
    @NotNull
    public static PsiElement createIdentifierFromText(@NotNull Project project, String text) {
        VdlFile file = createFileFromText(project, "package " + text);
        return file.getPackage().getIdentifier();
    }

    @NotNull
    private static VdlFile createFileFromText(@NotNull Project project, @NotNull String text) {
        return (VdlFile) PsiFileFactory.getInstance(project).createFileFromText("a.go", VdlLanguage.INSTANCE, text);
    }

    @NotNull
    public static VdlPackageClause createPackageClause(@NotNull Project project, @NotNull String name) {
        return createFileFromText(project, "package " + name).getPackage();
    }
}
