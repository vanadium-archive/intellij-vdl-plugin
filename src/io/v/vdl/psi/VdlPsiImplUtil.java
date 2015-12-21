package io.v.vdl.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.impl.source.tree.LeafElement;
import io.v.vdl.VdlStringLiteralEscaper;
import io.v.vdl.psi.impl.VdlStringLiteralImpl;
import org.jetbrains.annotations.NotNull;

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
}
