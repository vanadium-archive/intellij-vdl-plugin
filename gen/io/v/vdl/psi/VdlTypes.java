// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.v.vdl.psi.impl.*;

public interface VdlTypes {

  IElementType ACTION_IDENTIFIER = new VdlCompositeElementType("ACTION_IDENTIFIER");
  IElementType ADD_EXPR = new VdlCompositeElementType("ADD_EXPR");
  IElementType AND_EXPR = new VdlCompositeElementType("AND_EXPR");
  IElementType ANONYMOUS_FIELD_DEFINITION = new VdlCompositeElementType("ANONYMOUS_FIELD_DEFINITION");
  IElementType ARGUMENT_LIST = new VdlCompositeElementType("ARGUMENT_LIST");
  IElementType ARRAY_OR_SLICE_TYPE = new VdlCompositeElementType("ARRAY_OR_SLICE_TYPE");
  IElementType ASSIGNMENT_STATEMENT = new VdlCompositeElementType("ASSIGNMENT_STATEMENT");
  IElementType ASSIGN_OP = new VdlCompositeElementType("ASSIGN_OP");
  IElementType BLOCK = new VdlCompositeElementType("BLOCK");
  IElementType BREAK_STATEMENT = new VdlCompositeElementType("BREAK_STATEMENT");
  IElementType BUILTIN_ARGS = new VdlCompositeElementType("BUILTIN_ARGS");
  IElementType BUILTIN_CALL_EXPR = new VdlCompositeElementType("BUILTIN_CALL_EXPR");
  IElementType CALL_EXPR = new VdlCompositeElementType("CALL_EXPR");
  IElementType CHANNEL_TYPE = new VdlCompositeElementType("CHANNEL_TYPE");
  IElementType COMM_CASE = new VdlCompositeElementType("COMM_CASE");
  IElementType COMM_CLAUSE = new VdlCompositeElementType("COMM_CLAUSE");
  IElementType COMPOSITE_LIT = new VdlCompositeElementType("COMPOSITE_LIT");
  IElementType CONDITIONAL_EXPR = new VdlCompositeElementType("CONDITIONAL_EXPR");
  IElementType CONST_DECLARATION = new VdlCompositeElementType("CONST_DECLARATION");
  IElementType CONST_DEFINITION = new VdlCompositeElementType("CONST_DEFINITION");
  IElementType CONST_SPEC = new VdlCompositeElementType("CONST_SPEC");
  IElementType CONTINUE_STATEMENT = new VdlCompositeElementType("CONTINUE_STATEMENT");
  IElementType CONVERSION_EXPR = new VdlCompositeElementType("CONVERSION_EXPR");
  IElementType DEFER_STATEMENT = new VdlCompositeElementType("DEFER_STATEMENT");
  IElementType ELEMENT = new VdlCompositeElementType("ELEMENT");
  IElementType ELSE_STATEMENT = new VdlCompositeElementType("ELSE_STATEMENT");
  IElementType ENUM_FIELD_DECLARATION = new VdlCompositeElementType("ENUM_FIELD_DECLARATION");
  IElementType ENUM_TYPE = new VdlCompositeElementType("ENUM_TYPE");
  IElementType ERROR_DECLARATION = new VdlCompositeElementType("ERROR_DECLARATION");
  IElementType ERROR_DETAIL = new VdlCompositeElementType("ERROR_DETAIL");
  IElementType ERROR_IDENTIFIER = new VdlCompositeElementType("ERROR_IDENTIFIER");
  IElementType ERROR_LANGUAGE_SPEC = new VdlCompositeElementType("ERROR_LANGUAGE_SPEC");
  IElementType ERROR_RESULT = new VdlCompositeElementType("ERROR_RESULT");
  IElementType ERROR_SPEC = new VdlCompositeElementType("ERROR_SPEC");
  IElementType ERROR_TYPE_NAME = new VdlCompositeElementType("ERROR_TYPE_NAME");
  IElementType EXPRESSION = new VdlCompositeElementType("EXPRESSION");
  IElementType EXPR_CASE_CLAUSE = new VdlCompositeElementType("EXPR_CASE_CLAUSE");
  IElementType EXPR_SWITCH_STATEMENT = new VdlCompositeElementType("EXPR_SWITCH_STATEMENT");
  IElementType FALLTHROUGH_STATEMENT = new VdlCompositeElementType("FALLTHROUGH_STATEMENT");
  IElementType FIELD_DECLARATION = new VdlCompositeElementType("FIELD_DECLARATION");
  IElementType FIELD_DEFINITION = new VdlCompositeElementType("FIELD_DEFINITION");
  IElementType FIELD_NAME = new VdlCompositeElementType("FIELD_NAME");
  IElementType FOR_CLAUSE = new VdlCompositeElementType("FOR_CLAUSE");
  IElementType FOR_STATEMENT = new VdlCompositeElementType("FOR_STATEMENT");
  IElementType FUNCTION_DECLARATION = new VdlCompositeElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_LIT = new VdlCompositeElementType("FUNCTION_LIT");
  IElementType FUNCTION_TYPE = new VdlCompositeElementType("FUNCTION_TYPE");
  IElementType GOTO_STATEMENT = new VdlCompositeElementType("GOTO_STATEMENT");
  IElementType GO_STATEMENT = new VdlCompositeElementType("GO_STATEMENT");
  IElementType IF_STATEMENT = new VdlCompositeElementType("IF_STATEMENT");
  IElementType IMPORT_DECLARATION = new VdlCompositeElementType("IMPORT_DECLARATION");
  IElementType IMPORT_LIST = new VdlCompositeElementType("IMPORT_LIST");
  IElementType IMPORT_SPEC = VdlStubElementTypeFactory.factory("IMPORT_SPEC");
  IElementType IMPORT_STRING = new VdlCompositeElementType("IMPORT_STRING");
  IElementType INDEX_OR_SLICE_EXPR = new VdlCompositeElementType("INDEX_OR_SLICE_EXPR");
  IElementType INTERFACE_TYPE = new VdlCompositeElementType("INTERFACE_TYPE");
  IElementType KEY = new VdlCompositeElementType("KEY");
  IElementType LABELED_STATEMENT = new VdlCompositeElementType("LABELED_STATEMENT");
  IElementType LABEL_DEFINITION = new VdlCompositeElementType("LABEL_DEFINITION");
  IElementType LABEL_REF = new VdlCompositeElementType("LABEL_REF");
  IElementType LEFT_HAND_EXPR_LIST = new VdlCompositeElementType("LEFT_HAND_EXPR_LIST");
  IElementType LITERAL = new VdlCompositeElementType("LITERAL");
  IElementType LITERAL_TYPE_EXPR = new VdlCompositeElementType("LITERAL_TYPE_EXPR");
  IElementType LITERAL_VALUE = new VdlCompositeElementType("LITERAL_VALUE");
  IElementType MAP_TYPE = new VdlCompositeElementType("MAP_TYPE");
  IElementType METHOD_SPEC = VdlStubElementTypeFactory.factory("METHOD_SPEC");
  IElementType MUL_EXPR = new VdlCompositeElementType("MUL_EXPR");
  IElementType OR_EXPR = new VdlCompositeElementType("OR_EXPR");
  IElementType PACKAGE_CLAUSE = new VdlCompositeElementType("PACKAGE_CLAUSE");
  IElementType PARAMETERS = new VdlCompositeElementType("PARAMETERS");
  IElementType PARAMETER_DECLARATION = new VdlCompositeElementType("PARAMETER_DECLARATION");
  IElementType PARAM_DEFINITION = new VdlCompositeElementType("PARAM_DEFINITION");
  IElementType PARENTHESES_EXPR = new VdlCompositeElementType("PARENTHESES_EXPR");
  IElementType PAR_TYPE = new VdlCompositeElementType("PAR_TYPE");
  IElementType POINTER_TYPE = new VdlCompositeElementType("POINTER_TYPE");
  IElementType RANGE_CLAUSE = new VdlCompositeElementType("RANGE_CLAUSE");
  IElementType RECEIVER_TYPE = new VdlCompositeElementType("RECEIVER_TYPE");
  IElementType RECV_STATEMENT = new VdlCompositeElementType("RECV_STATEMENT");
  IElementType REFERENCE_EXPRESSION = new VdlCompositeElementType("REFERENCE_EXPRESSION");
  IElementType RESULT = new VdlCompositeElementType("RESULT");
  IElementType RESULT_PARAMETERS = new VdlCompositeElementType("RESULT_PARAMETERS");
  IElementType RETURN_STATEMENT = new VdlCompositeElementType("RETURN_STATEMENT");
  IElementType SELECTOR_EXPR = new VdlCompositeElementType("SELECTOR_EXPR");
  IElementType SELECT_STATEMENT = new VdlCompositeElementType("SELECT_STATEMENT");
  IElementType SEND_STATEMENT = new VdlCompositeElementType("SEND_STATEMENT");
  IElementType SET_TYPE = new VdlCompositeElementType("SET_TYPE");
  IElementType SHORT_VAR_DECLARATION = new VdlCompositeElementType("SHORT_VAR_DECLARATION");
  IElementType SIGNATURE = new VdlCompositeElementType("SIGNATURE");
  IElementType SIMPLE_STATEMENT = new VdlCompositeElementType("SIMPLE_STATEMENT");
  IElementType SPEC_TYPE = new VdlCompositeElementType("SPEC_TYPE");
  IElementType STATEMENT = new VdlCompositeElementType("STATEMENT");
  IElementType STREAM_ARGS = new VdlCompositeElementType("STREAM_ARGS");
  IElementType STREAM_SPEC = new VdlCompositeElementType("STREAM_SPEC");
  IElementType STRING_LITERAL = new VdlCompositeElementType("STRING_LITERAL");
  IElementType STRUCT_TYPE = new VdlCompositeElementType("STRUCT_TYPE");
  IElementType SWITCH_START = new VdlCompositeElementType("SWITCH_START");
  IElementType SWITCH_STATEMENT = new VdlCompositeElementType("SWITCH_STATEMENT");
  IElementType TAG = new VdlCompositeElementType("TAG");
  IElementType TAGS = new VdlCompositeElementType("TAGS");
  IElementType TYPE = new VdlCompositeElementType("TYPE");
  IElementType TYPE_ASSERTION_EXPR = new VdlCompositeElementType("TYPE_ASSERTION_EXPR");
  IElementType TYPE_CASE_CLAUSE = new VdlCompositeElementType("TYPE_CASE_CLAUSE");
  IElementType TYPE_DECLARATION = new VdlCompositeElementType("TYPE_DECLARATION");
  IElementType TYPE_GUARD = new VdlCompositeElementType("TYPE_GUARD");
  IElementType TYPE_LIST = new VdlCompositeElementType("TYPE_LIST");
  IElementType TYPE_REFERENCE_EXPRESSION = new VdlCompositeElementType("TYPE_REFERENCE_EXPRESSION");
  IElementType TYPE_SPEC = VdlStubElementTypeFactory.factory("TYPE_SPEC");
  IElementType TYPE_SWITCH_GUARD = new VdlCompositeElementType("TYPE_SWITCH_GUARD");
  IElementType TYPE_SWITCH_STATEMENT = new VdlCompositeElementType("TYPE_SWITCH_STATEMENT");
  IElementType UNARY_EXPR = new VdlCompositeElementType("UNARY_EXPR");
  IElementType UNION_TYPE = new VdlCompositeElementType("UNION_TYPE");
  IElementType VALUE = new VdlCompositeElementType("VALUE");
  IElementType VAR_DECLARATION = new VdlCompositeElementType("VAR_DECLARATION");
  IElementType VAR_DEFINITION = new VdlCompositeElementType("VAR_DEFINITION");
  IElementType VAR_SPEC = new VdlCompositeElementType("VAR_SPEC");

  IElementType ASSIGN = new VdlTokenType("=");
  IElementType BIT_AND = new VdlTokenType("&");
  IElementType BIT_AND_ASSIGN = new VdlTokenType("&=");
  IElementType BIT_CLEAR = new VdlTokenType("&^");
  IElementType BIT_CLEAR_ASSIGN = new VdlTokenType("&^=");
  IElementType BIT_OR = new VdlTokenType("|");
  IElementType BIT_OR_ASSIGN = new VdlTokenType("|=");
  IElementType BIT_XOR = new VdlTokenType("^");
  IElementType BIT_XOR_ASSIGN = new VdlTokenType("^=");
  IElementType BREAK = new VdlTokenType("break");
  IElementType CASE = new VdlTokenType("case");
  IElementType CHAN = new VdlTokenType("chan");
  IElementType CHAR = new VdlTokenType("char");
  IElementType COLON = new VdlTokenType(":");
  IElementType COMMA = new VdlTokenType(",");
  IElementType COND_AND = new VdlTokenType("&&");
  IElementType COND_OR = new VdlTokenType("||");
  IElementType CONST = new VdlTokenType("const");
  IElementType CONTINUE = new VdlTokenType("continue");
  IElementType DECIMALI = new VdlTokenType("decimali");
  IElementType DEFAULT = new VdlTokenType("default");
  IElementType DEFER = new VdlTokenType("defer");
  IElementType DOT = new VdlTokenType(".");
  IElementType ELSE = new VdlTokenType("else");
  IElementType ENUM = new VdlTokenType("enum");
  IElementType EQ = new VdlTokenType("==");
  IElementType ERROR = new VdlTokenType("error");
  IElementType FALLTHROUGH = new VdlTokenType("fallthrough");
  IElementType FLOAT = new VdlTokenType("float");
  IElementType FLOATI = new VdlTokenType("floati");
  IElementType FOR = new VdlTokenType("for");
  IElementType FUNC = new VdlTokenType("func");
  IElementType GO = new VdlTokenType("go");
  IElementType GOTO = new VdlTokenType("goto");
  IElementType GREATER = new VdlTokenType(">");
  IElementType GREATER_OR_EQUAL = new VdlTokenType(">=");
  IElementType HEX = new VdlTokenType("hex");
  IElementType IDENTIFIER = new VdlTokenType("identifier");
  IElementType IF = new VdlTokenType("if");
  IElementType IMPORT = new VdlTokenType("import");
  IElementType INT = new VdlTokenType("int");
  IElementType INTERFACE = new VdlTokenType("interface");
  IElementType LBRACE = new VdlTokenType("{");
  IElementType LBRACK = new VdlTokenType("[");
  IElementType LESS = new VdlTokenType("<");
  IElementType LESS_OR_EQUAL = new VdlTokenType("<=");
  IElementType LPAREN = new VdlTokenType("(");
  IElementType MAP = new VdlTokenType("map");
  IElementType MINUS = new VdlTokenType("-");
  IElementType MINUS_ASSIGN = new VdlTokenType("-=");
  IElementType MINUS_MINUS = new VdlTokenType("--");
  IElementType MUL = new VdlTokenType("*");
  IElementType MUL_ASSIGN = new VdlTokenType("*=");
  IElementType NOT = new VdlTokenType("!");
  IElementType NOT_EQ = new VdlTokenType("!=");
  IElementType OCT = new VdlTokenType("oct");
  IElementType OPTIONAL_ARG = new VdlTokenType("?");
  IElementType PACKAGE = new VdlTokenType("package");
  IElementType PLUS = new VdlTokenType("+");
  IElementType PLUS_ASSIGN = new VdlTokenType("+=");
  IElementType PLUS_PLUS = new VdlTokenType("++");
  IElementType QUOTIENT = new VdlTokenType("/");
  IElementType QUOTIENT_ASSIGN = new VdlTokenType("/=");
  IElementType RANGE = new VdlTokenType("range");
  IElementType RAW_STRING = new VdlTokenType("raw_string");
  IElementType RBRACE = new VdlTokenType("}");
  IElementType RBRACK = new VdlTokenType("]");
  IElementType REMAINDER = new VdlTokenType("%");
  IElementType REMAINDER_ASSIGN = new VdlTokenType("%=");
  IElementType RETURN = new VdlTokenType("return");
  IElementType RPAREN = new VdlTokenType(")");
  IElementType SELECT = new VdlTokenType("select");
  IElementType SEMICOLON = new VdlTokenType(";");
  IElementType SEMICOLON_SYNTHETIC = new VdlTokenType("<NL>");
  IElementType SEND_CHANNEL = new VdlTokenType("<-");
  IElementType SET = new VdlTokenType("set");
  IElementType SHIFT_LEFT = new VdlTokenType("<<");
  IElementType SHIFT_LEFT_ASSIGN = new VdlTokenType("<<=");
  IElementType SHIFT_RIGHT = new VdlTokenType(">>");
  IElementType SHIFT_RIGHT_ASSIGN = new VdlTokenType(">>=");
  IElementType STREAM = new VdlTokenType("stream");
  IElementType STRING = new VdlTokenType("string");
  IElementType STRUCT = new VdlTokenType("struct");
  IElementType SWITCH = new VdlTokenType("switch");
  IElementType TRIPLE_DOT = new VdlTokenType("...");
  IElementType TYPE_ = new VdlTokenType("type");
  IElementType UNION = new VdlTokenType("union");
  IElementType VAR = new VdlTokenType("var");
  IElementType VAR_ASSIGN = new VdlTokenType(":=");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ACTION_IDENTIFIER) {
        return new VdlActionIdentifierImpl(node);
      }
      else if (type == ADD_EXPR) {
        return new VdlAddExprImpl(node);
      }
      else if (type == AND_EXPR) {
        return new VdlAndExprImpl(node);
      }
      else if (type == ANONYMOUS_FIELD_DEFINITION) {
        return new VdlAnonymousFieldDefinitionImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new VdlArgumentListImpl(node);
      }
      else if (type == ARRAY_OR_SLICE_TYPE) {
        return new VdlArrayOrSliceTypeImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new VdlAssignmentStatementImpl(node);
      }
      else if (type == ASSIGN_OP) {
        return new VdlAssignOpImpl(node);
      }
      else if (type == BLOCK) {
        return new VdlBlockImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new VdlBreakStatementImpl(node);
      }
      else if (type == BUILTIN_ARGS) {
        return new VdlBuiltinArgsImpl(node);
      }
      else if (type == BUILTIN_CALL_EXPR) {
        return new VdlBuiltinCallExprImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new VdlCallExprImpl(node);
      }
      else if (type == CHANNEL_TYPE) {
        return new VdlChannelTypeImpl(node);
      }
      else if (type == COMM_CASE) {
        return new VdlCommCaseImpl(node);
      }
      else if (type == COMM_CLAUSE) {
        return new VdlCommClauseImpl(node);
      }
      else if (type == COMPOSITE_LIT) {
        return new VdlCompositeLitImpl(node);
      }
      else if (type == CONDITIONAL_EXPR) {
        return new VdlConditionalExprImpl(node);
      }
      else if (type == CONST_DECLARATION) {
        return new VdlConstDeclarationImpl(node);
      }
      else if (type == CONST_DEFINITION) {
        return new VdlConstDefinitionImpl(node);
      }
      else if (type == CONST_SPEC) {
        return new VdlConstSpecImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new VdlContinueStatementImpl(node);
      }
      else if (type == CONVERSION_EXPR) {
        return new VdlConversionExprImpl(node);
      }
      else if (type == DEFER_STATEMENT) {
        return new VdlDeferStatementImpl(node);
      }
      else if (type == ELEMENT) {
        return new VdlElementImpl(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new VdlElseStatementImpl(node);
      }
      else if (type == ENUM_FIELD_DECLARATION) {
        return new VdlEnumFieldDeclarationImpl(node);
      }
      else if (type == ENUM_TYPE) {
        return new VdlEnumTypeImpl(node);
      }
      else if (type == ERROR_DECLARATION) {
        return new VdlErrorDeclarationImpl(node);
      }
      else if (type == ERROR_DETAIL) {
        return new VdlErrorDetailImpl(node);
      }
      else if (type == ERROR_IDENTIFIER) {
        return new VdlErrorIdentifierImpl(node);
      }
      else if (type == ERROR_LANGUAGE_SPEC) {
        return new VdlErrorLanguageSpecImpl(node);
      }
      else if (type == ERROR_RESULT) {
        return new VdlErrorResultImpl(node);
      }
      else if (type == ERROR_SPEC) {
        return new VdlErrorSpecImpl(node);
      }
      else if (type == ERROR_TYPE_NAME) {
        return new VdlErrorTypeNameImpl(node);
      }
      else if (type == EXPRESSION) {
        return new VdlExpressionImpl(node);
      }
      else if (type == EXPR_CASE_CLAUSE) {
        return new VdlExprCaseClauseImpl(node);
      }
      else if (type == EXPR_SWITCH_STATEMENT) {
        return new VdlExprSwitchStatementImpl(node);
      }
      else if (type == FALLTHROUGH_STATEMENT) {
        return new VdlFallthroughStatementImpl(node);
      }
      else if (type == FIELD_DECLARATION) {
        return new VdlFieldDeclarationImpl(node);
      }
      else if (type == FIELD_DEFINITION) {
        return new VdlFieldDefinitionImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new VdlFieldNameImpl(node);
      }
      else if (type == FOR_CLAUSE) {
        return new VdlForClauseImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new VdlForStatementImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new VdlFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_LIT) {
        return new VdlFunctionLitImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new VdlFunctionTypeImpl(node);
      }
      else if (type == GOTO_STATEMENT) {
        return new VdlGotoStatementImpl(node);
      }
      else if (type == GO_STATEMENT) {
        return new VdlGoStatementImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new VdlIfStatementImpl(node);
      }
      else if (type == IMPORT_DECLARATION) {
        return new VdlImportDeclarationImpl(node);
      }
      else if (type == IMPORT_LIST) {
        return new VdlImportListImpl(node);
      }
      else if (type == IMPORT_SPEC) {
        return new VdlImportSpecImpl(node);
      }
      else if (type == IMPORT_STRING) {
        return new VdlImportStringImpl(node);
      }
      else if (type == INDEX_OR_SLICE_EXPR) {
        return new VdlIndexOrSliceExprImpl(node);
      }
      else if (type == INTERFACE_TYPE) {
        return new VdlInterfaceTypeImpl(node);
      }
      else if (type == KEY) {
        return new VdlKeyImpl(node);
      }
      else if (type == LABELED_STATEMENT) {
        return new VdlLabeledStatementImpl(node);
      }
      else if (type == LABEL_DEFINITION) {
        return new VdlLabelDefinitionImpl(node);
      }
      else if (type == LABEL_REF) {
        return new VdlLabelRefImpl(node);
      }
      else if (type == LEFT_HAND_EXPR_LIST) {
        return new VdlLeftHandExprListImpl(node);
      }
      else if (type == LITERAL) {
        return new VdlLiteralImpl(node);
      }
      else if (type == LITERAL_TYPE_EXPR) {
        return new VdlLiteralTypeExprImpl(node);
      }
      else if (type == LITERAL_VALUE) {
        return new VdlLiteralValueImpl(node);
      }
      else if (type == MAP_TYPE) {
        return new VdlMapTypeImpl(node);
      }
      else if (type == METHOD_SPEC) {
        return new VdlMethodSpecImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new VdlMulExprImpl(node);
      }
      else if (type == OR_EXPR) {
        return new VdlOrExprImpl(node);
      }
      else if (type == PACKAGE_CLAUSE) {
        return new VdlPackageClauseImpl(node);
      }
      else if (type == PARAMETERS) {
        return new VdlParametersImpl(node);
      }
      else if (type == PARAMETER_DECLARATION) {
        return new VdlParameterDeclarationImpl(node);
      }
      else if (type == PARAM_DEFINITION) {
        return new VdlParamDefinitionImpl(node);
      }
      else if (type == PARENTHESES_EXPR) {
        return new VdlParenthesesExprImpl(node);
      }
      else if (type == PAR_TYPE) {
        return new VdlParTypeImpl(node);
      }
      else if (type == POINTER_TYPE) {
        return new VdlPointerTypeImpl(node);
      }
      else if (type == RANGE_CLAUSE) {
        return new VdlRangeClauseImpl(node);
      }
      else if (type == RECEIVER_TYPE) {
        return new VdlReceiverTypeImpl(node);
      }
      else if (type == RECV_STATEMENT) {
        return new VdlRecvStatementImpl(node);
      }
      else if (type == REFERENCE_EXPRESSION) {
        return new VdlReferenceExpressionImpl(node);
      }
      else if (type == RESULT) {
        return new VdlResultImpl(node);
      }
      else if (type == RESULT_PARAMETERS) {
        return new VdlResultParametersImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new VdlReturnStatementImpl(node);
      }
      else if (type == SELECTOR_EXPR) {
        return new VdlSelectorExprImpl(node);
      }
      else if (type == SELECT_STATEMENT) {
        return new VdlSelectStatementImpl(node);
      }
      else if (type == SEND_STATEMENT) {
        return new VdlSendStatementImpl(node);
      }
      else if (type == SET_TYPE) {
        return new VdlSetTypeImpl(node);
      }
      else if (type == SHORT_VAR_DECLARATION) {
        return new VdlShortVarDeclarationImpl(node);
      }
      else if (type == SIGNATURE) {
        return new VdlSignatureImpl(node);
      }
      else if (type == SIMPLE_STATEMENT) {
        return new VdlSimpleStatementImpl(node);
      }
      else if (type == SPEC_TYPE) {
        return new VdlSpecTypeImpl(node);
      }
      else if (type == STATEMENT) {
        return new VdlStatementImpl(node);
      }
      else if (type == STREAM_ARGS) {
        return new VdlStreamArgsImpl(node);
      }
      else if (type == STREAM_SPEC) {
        return new VdlStreamSpecImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new VdlStringLiteralImpl(node);
      }
      else if (type == STRUCT_TYPE) {
        return new VdlStructTypeImpl(node);
      }
      else if (type == SWITCH_START) {
        return new VdlSwitchStartImpl(node);
      }
      else if (type == SWITCH_STATEMENT) {
        return new VdlSwitchStatementImpl(node);
      }
      else if (type == TAG) {
        return new VdlTagImpl(node);
      }
      else if (type == TAGS) {
        return new VdlTagsImpl(node);
      }
      else if (type == TYPE) {
        return new VdlTypeImpl(node);
      }
      else if (type == TYPE_ASSERTION_EXPR) {
        return new VdlTypeAssertionExprImpl(node);
      }
      else if (type == TYPE_CASE_CLAUSE) {
        return new VdlTypeCaseClauseImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new VdlTypeDeclarationImpl(node);
      }
      else if (type == TYPE_GUARD) {
        return new VdlTypeGuardImpl(node);
      }
      else if (type == TYPE_LIST) {
        return new VdlTypeListImpl(node);
      }
      else if (type == TYPE_REFERENCE_EXPRESSION) {
        return new VdlTypeReferenceExpressionImpl(node);
      }
      else if (type == TYPE_SPEC) {
        return new VdlTypeSpecImpl(node);
      }
      else if (type == TYPE_SWITCH_GUARD) {
        return new VdlTypeSwitchGuardImpl(node);
      }
      else if (type == TYPE_SWITCH_STATEMENT) {
        return new VdlTypeSwitchStatementImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new VdlUnaryExprImpl(node);
      }
      else if (type == UNION_TYPE) {
        return new VdlUnionTypeImpl(node);
      }
      else if (type == VALUE) {
        return new VdlValueImpl(node);
      }
      else if (type == VAR_DECLARATION) {
        return new VdlVarDeclarationImpl(node);
      }
      else if (type == VAR_DEFINITION) {
        return new VdlVarDefinitionImpl(node);
      }
      else if (type == VAR_SPEC) {
        return new VdlVarSpecImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
