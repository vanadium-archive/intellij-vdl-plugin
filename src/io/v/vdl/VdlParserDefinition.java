package io.v.vdl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import io.v.vdl.psi.VdlFile;
import io.v.vdl.psi.VdlTokenType;
import io.v.vdl.psi.VdlTypes;
import org.jetbrains.annotations.NotNull;

import static io.v.vdl.psi.VdlTypes.*;

public class VdlParserDefinition implements ParserDefinition {
    public static final IElementType LINE_COMMENT = new VdlTokenType("GO_LINE_COMMENT");
    public static final IElementType MULTILINE_COMMENT = new VdlTokenType("GO_MULTILINE_COMMENT");

    public static final IElementType WS = new VdlTokenType("GO_WHITESPACE");
    public static final IElementType NLS = new VdlTokenType("GO_WS_NEW_LINES");

    public static final TokenSet WHITESPACES = TokenSet.create(WS, NLS);
    public static final TokenSet COMMENTS = TokenSet.create(LINE_COMMENT, MULTILINE_COMMENT);
    public static final TokenSet STRING_LITERALS = TokenSet.create(STRING, RAW_STRING, CHAR);
    public static final TokenSet NUMBERS = TokenSet.create(INT, FLOAT, FLOATI, DECIMALI, FLOATI); // todo: HEX, OCT,
    public static final TokenSet KEYWORDS = TokenSet.create(
            PACKAGE, IMPORT, BREAK, CASE, CHAN, CONST, CONTINUE, DEFAULT, DEFER, ELSE, FALLTHROUGH, FOR, FUNC, GO, GOTO, IF, IMPORT,
            INTERFACE, MAP, PACKAGE, RANGE, RETURN, SELECT, STRUCT, SWITCH, TYPE_, VAR);
    public static final TokenSet OPERATORS = TokenSet.create(
            EQ, ASSIGN, NOT_EQ, NOT, PLUS_PLUS, PLUS_ASSIGN, PLUS, MINUS_MINUS, MINUS_ASSIGN, MINUS, COND_OR, BIT_OR_ASSIGN, BIT_OR,
            BIT_CLEAR_ASSIGN, BIT_CLEAR, COND_AND, BIT_AND_ASSIGN, BIT_AND, SHIFT_LEFT_ASSIGN, SHIFT_LEFT, SEND_CHANNEL, LESS_OR_EQUAL,
            LESS, BIT_XOR_ASSIGN, BIT_XOR, MUL_ASSIGN, MUL, QUOTIENT_ASSIGN, QUOTIENT, REMAINDER_ASSIGN, REMAINDER, SHIFT_RIGHT_ASSIGN,
            SHIFT_RIGHT, GREATER_OR_EQUAL, GREATER, VAR_ASSIGN);

    public static final IFileElementType FILE = new IFileElementType(Language.<VdlLanguage>findInstance(VdlLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new VdlLexer();
    }

    @NotNull
    @Override
    public PsiParser createParser(Project project) {
        return new VdlParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITESPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRING_LITERALS;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return VdlTypes.Factory.createElement(node);
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new VdlFile(viewProvider);
    }

    @NotNull
    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
}
