// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.GlobalSearchScopesCore;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.containers.ContainerUtil;
import io.v.vdl.VdlStringLiteralEscaper;
import io.v.vdl.psi.impl.VdlStringLiteralImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VdlPsiImplUtil {
    @NotNull
    public static VdlStringLiteralEscaper createLiteralTextEscaper(@NotNull VdlStringLiteral o) {
        return new VdlStringLiteralEscaper(o);
    }

    @NotNull
    public static VdlStringLiteralImpl updateText(@NotNull VdlStringLiteral o, @NotNull String text) {
        if (text.length() > 2) {
            if (o.getString() != null) {
                StringBuilder outChars = new StringBuilder();
                VdlStringLiteralEscaper.escapeString(text.substring(1, text.length()-1), outChars);
                outChars.insert(0, '"');
                outChars.append('"');
                text = outChars.toString();
            }
        }

        ASTNode valueNode = o.getNode().getFirstChildNode();
        assert valueNode instanceof LeafElement;

        ((LeafElement)valueNode).replaceWithText(text);
        return (VdlStringLiteralImpl)o;
    }

    public static boolean isValidHost(@SuppressWarnings("UnusedParameters") @NotNull VdlStringLiteral o) {
        return true;
    }

    public static boolean shouldGoDeeper(@SuppressWarnings("UnusedParameters")  @NotNull VdlTypeSpec o) {
        return false;
    }

    @Nullable
    public static String getName(@NotNull VdlPackageClause packageClause) {
        PsiElement packageIdentifier = packageClause.getIdentifier();
        if (packageIdentifier != null) {
            return packageIdentifier.getText().trim();
        }
        return null;
    }

    public static int getArity(@Nullable VdlSignature s) {
        return s == null ? -1 : s.getParameters().getParameterDeclarationList().size();
    }

    public static boolean isDot(@NotNull VdlImportSpec importSpec) {
        VdlImportSpecStub stub = importSpec.getStub();
        return stub != null ? stub.isDot() : importSpec.getDot() != null;
    }

    @NotNull
    public static String getPath(@NotNull VdlImportSpec importSpec) {
        VdlImportSpecStub stub = importSpec.getStub();
        return stub != null ? stub.getPath() : importSpec.getImportString().getPath();
    }

    @NotNull
    public static String getPath(@NotNull VdlImportString o) {
        return unquote(o.getText());
    }

    @NotNull
    public static String unquote(@Nullable String s) {
        if (StringUtil.isEmpty(s)) return "";
        char quote = s.charAt(0);
        int startOffset = isQuote(quote) ? 1 : 0;
        int endOffset = s.length();
        if (s.length() > 1) {
            char lastChar = s.charAt(s.length() - 1);
            if (isQuote(quote) && lastChar == quote) {
                endOffset = s.length() - 1;
            }
            if (!isQuote(quote) && isQuote(lastChar)){
                endOffset = s.length() - 1;
            }
        }
        return s.substring(startOffset, endOffset);
    }

    private static boolean isQuote(char ch) {
        return ch == '"' || ch == '\'' || ch == '`';
    }

    public static String getAlias(@NotNull VdlImportSpec importSpec) {
        VdlImportSpecStub stub = importSpec.getStub();
        if (stub != null) {
            return stub.getAlias();
        }

        PsiElement identifier = importSpec.getIdentifier();
        if (identifier != null) {
            return identifier.getText();
        }
        return importSpec.isDot() ? "." : null;
    }

    public static String getName(@NotNull VdlImportSpec importSpec) {
        return getAlias(importSpec);
    }

    public static VdlTypeReferenceExpression getTypeReference(VdlType type) {
        if (type == null) return null;
        if (type instanceof VdlReceiverType) {
            return PsiTreeUtil.findChildOfAnyType(type, VdlTypeReferenceExpression.class);
        }
        return type.getTypeReferenceExpression();
    }
}
