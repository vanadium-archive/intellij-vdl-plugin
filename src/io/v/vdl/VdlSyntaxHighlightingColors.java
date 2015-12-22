package io.v.vdl;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class VdlSyntaxHighlightingColors {
    public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey("VDL_LINE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey("VDL_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("VDL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING = createTextAttributesKey("VDL_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("VDL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("VDL_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BRACES = createTextAttributesKey("VDL_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey PARENTHESES = createTextAttributesKey("VDL_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("VDL_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("VDL_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey DOT = createTextAttributesKey("VDL_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("VDL_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey COLON = createTextAttributesKey("VDL_COLON", HighlighterColors.TEXT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("VDL_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("VDL_BAD_TOKEN", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey OPTIONAL_ARG = createTextAttributesKey("VDL_OPTIONAL_ARG", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey TYPE_SPECIFICATION = createTextAttributesKey("VDL_TYPE_SPECIFICATION", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey TYPE_REFERENCE = createTextAttributesKey("VDL_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey BUILTIN_TYPE_REFERENCE = createTextAttributesKey("VDL_BUILTIN_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey EXPORTED_FUNCTION = createTextAttributesKey("VDL_EXPORTED_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey LOCAL_FUNCTION = createTextAttributesKey("VDL_LOCAL_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey PACKAGE_EXPORTED_INTERFACE = createTextAttributesKey("VDL_PACKAGE_EXPORTED_INTERFACE", DefaultLanguageHighlighterColors.INTERFACE_NAME);
    public static final TextAttributesKey PACKAGE_EXPORTED_STRUCT = createTextAttributesKey("VDL_PACKAGE_EXPORTED_STRUCT", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey PACKAGE_EXPORTED_CONSTANT = createTextAttributesKey("VDL_PACKAGE_EXPORTED_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey PACKAGE_EXPORTED_VARIABLE = createTextAttributesKey("VDL_PACKAGE_EXPORTED_VARIABLE", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
    public static final TextAttributesKey PACKAGE_LOCAL_INTERFACE = createTextAttributesKey("VDL_PACKAGE_LOCAL_INTERFACE", DefaultLanguageHighlighterColors.INTERFACE_NAME);
    public static final TextAttributesKey PACKAGE_LOCAL_STRUCT = createTextAttributesKey("VDL_PACKAGE_LOCAL_STRUCT", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey PACKAGE_LOCAL_CONSTANT = createTextAttributesKey("VDL_PACKAGE_LOCAL_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey PACKAGE_LOCAL_VARIABLE = createTextAttributesKey("VDL_PACKAGE_LOCAL_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey STRUCT_EXPORTED_MEMBER = createTextAttributesKey("VDL_STRUCT_EXPORTED_MEMBER", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
    public static final TextAttributesKey STRUCT_LOCAL_MEMBER = createTextAttributesKey("VDL_STRUCT_LOCAL_MEMBER", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey METHOD_RECEIVER = createTextAttributesKey("VDL_METHOD_RECEIVER", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey FUNCTION_PARAMETER = createTextAttributesKey("VDL_FUNCTION_PARAMETER", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey LOCAL_CONSTANT = createTextAttributesKey("VDL_LOCAL_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey LOCAL_VARIABLE = createTextAttributesKey("VDL_LOCAL_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey SCOPE_VARIABLE = createTextAttributesKey("VDL_SCOPE_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey LABEL = createTextAttributesKey("VDL_LABEL", DefaultLanguageHighlighterColors.LABEL);
    private VdlSyntaxHighlightingColors() {
    }
}
