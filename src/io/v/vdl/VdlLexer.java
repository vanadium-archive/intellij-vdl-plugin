package io.v.vdl;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;

public class VdlLexer extends MergingLexerAdapter {
    public VdlLexer() {
        super(new FlexAdapter(new _VdlLexer()), TokenSet.orSet(VdlParserDefinition.COMMENTS, VdlParserDefinition.WHITESPACES));
    }
}
