package io.v.vdl;

import com.intellij.lexer.FlexAdapter;

public class VdlLexerAdapter extends FlexAdapter {
    public VdlLexerAdapter() {
        super(new VdlLexer(null));
    }
}
