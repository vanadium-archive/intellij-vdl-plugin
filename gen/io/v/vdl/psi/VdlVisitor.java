// This is a generated file. Not intended for manual editing.
package io.v.vdl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiLanguageInjectionHost;

public class VdlVisitor extends PsiElementVisitor {

  public void visitActionIdentifier(@NotNull VdlActionIdentifier o) {
    visitCompositeElement(o);
  }

  public void visitAddExpr(@NotNull VdlAddExpr o) {
    visitBinaryExpr(o);
  }

  public void visitAndExpr(@NotNull VdlAndExpr o) {
    visitExpression(o);
  }

  public void visitAnonymousFieldDefinition(@NotNull VdlAnonymousFieldDefinition o) {
    visitCompositeElement(o);
  }

  public void visitArgumentList(@NotNull VdlArgumentList o) {
    visitCompositeElement(o);
  }

  public void visitArrayOrSliceType(@NotNull VdlArrayOrSliceType o) {
    visitType(o);
  }

  public void visitAssignmentStatement(@NotNull VdlAssignmentStatement o) {
    visitStatement(o);
  }

  public void visitBinaryExpr(@NotNull VdlBinaryExpr o) {
    visitExpression(o);
  }

  public void visitBlock(@NotNull VdlBlock o) {
    visitCompositeElement(o);
  }

  public void visitBreakStatement(@NotNull VdlBreakStatement o) {
    visitStatement(o);
  }

  public void visitBuiltinArgs(@NotNull VdlBuiltinArgs o) {
    visitCompositeElement(o);
  }

  public void visitBuiltinCallExpr(@NotNull VdlBuiltinCallExpr o) {
    visitExpression(o);
  }

  public void visitCallExpr(@NotNull VdlCallExpr o) {
    visitExpression(o);
  }

  public void visitChannelType(@NotNull VdlChannelType o) {
    visitType(o);
  }

  public void visitCommCase(@NotNull VdlCommCase o) {
    visitCompositeElement(o);
  }

  public void visitCommClause(@NotNull VdlCommClause o) {
    visitCompositeElement(o);
  }

  public void visitCompositeLit(@NotNull VdlCompositeLit o) {
    visitExpression(o);
  }

  public void visitConditionalExpr(@NotNull VdlConditionalExpr o) {
    visitExpression(o);
  }

  public void visitConstDeclaration(@NotNull VdlConstDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitConstDefinition(@NotNull VdlConstDefinition o) {
    visitCompositeElement(o);
  }

  public void visitConstSpec(@NotNull VdlConstSpec o) {
    visitCompositeElement(o);
  }

  public void visitContinueStatement(@NotNull VdlContinueStatement o) {
    visitStatement(o);
  }

  public void visitConversionExpr(@NotNull VdlConversionExpr o) {
    visitBinaryExpr(o);
  }

  public void visitDeferStatement(@NotNull VdlDeferStatement o) {
    visitStatement(o);
  }

  public void visitElement(@NotNull VdlElement o) {
    visitCompositeElement(o);
  }

  public void visitElseStatement(@NotNull VdlElseStatement o) {
    visitStatement(o);
  }

  public void visitEnumFieldDeclaration(@NotNull VdlEnumFieldDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitEnumType(@NotNull VdlEnumType o) {
    visitType(o);
  }

  public void visitErrorDeclaration(@NotNull VdlErrorDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitErrorDetail(@NotNull VdlErrorDetail o) {
    visitCompositeElement(o);
  }

  public void visitErrorIdentifier(@NotNull VdlErrorIdentifier o) {
    visitCompositeElement(o);
  }

  public void visitErrorLanguageSpec(@NotNull VdlErrorLanguageSpec o) {
    visitCompositeElement(o);
  }

  public void visitErrorResult(@NotNull VdlErrorResult o) {
    visitCompositeElement(o);
  }

  public void visitErrorSpec(@NotNull VdlErrorSpec o) {
    visitCompositeElement(o);
  }

  public void visitErrorTypeName(@NotNull VdlErrorTypeName o) {
    visitCompositeElement(o);
  }

  public void visitExprCaseClause(@NotNull VdlExprCaseClause o) {
    visitCompositeElement(o);
  }

  public void visitExprSwitchStatement(@NotNull VdlExprSwitchStatement o) {
    visitSwitchStatement(o);
  }

  public void visitExpression(@NotNull VdlExpression o) {
    visitCompositeElement(o);
  }

  public void visitFallthroughStatement(@NotNull VdlFallthroughStatement o) {
    visitStatement(o);
  }

  public void visitFieldDeclaration(@NotNull VdlFieldDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitFieldDefinition(@NotNull VdlFieldDefinition o) {
    visitCompositeElement(o);
  }

  public void visitFieldName(@NotNull VdlFieldName o) {
    visitCompositeElement(o);
  }

  public void visitForClause(@NotNull VdlForClause o) {
    visitCompositeElement(o);
  }

  public void visitForStatement(@NotNull VdlForStatement o) {
    visitStatement(o);
  }

  public void visitFunctionDeclaration(@NotNull VdlFunctionDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitFunctionLit(@NotNull VdlFunctionLit o) {
    visitExpression(o);
  }

  public void visitFunctionType(@NotNull VdlFunctionType o) {
    visitType(o);
  }

  public void visitGoStatement(@NotNull VdlGoStatement o) {
    visitStatement(o);
  }

  public void visitGotoStatement(@NotNull VdlGotoStatement o) {
    visitStatement(o);
  }

  public void visitIfStatement(@NotNull VdlIfStatement o) {
    visitStatement(o);
  }

  public void visitImportDeclaration(@NotNull VdlImportDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitImportList(@NotNull VdlImportList o) {
    visitCompositeElement(o);
  }

  public void visitImportSpec(@NotNull VdlImportSpec o) {
    visitNamedElement(o);
  }

  public void visitImportString(@NotNull VdlImportString o) {
    visitCompositeElement(o);
  }

  public void visitIndexOrSliceExpr(@NotNull VdlIndexOrSliceExpr o) {
    visitExpression(o);
  }

  public void visitInterfaceType(@NotNull VdlInterfaceType o) {
    visitType(o);
  }

  public void visitKey(@NotNull VdlKey o) {
    visitCompositeElement(o);
  }

  public void visitLabelDefinition(@NotNull VdlLabelDefinition o) {
    visitCompositeElement(o);
  }

  public void visitLabelRef(@NotNull VdlLabelRef o) {
    visitCompositeElement(o);
  }

  public void visitLabeledStatement(@NotNull VdlLabeledStatement o) {
    visitStatement(o);
  }

  public void visitLeftHandExprList(@NotNull VdlLeftHandExprList o) {
    visitCompositeElement(o);
  }

  public void visitLiteral(@NotNull VdlLiteral o) {
    visitExpression(o);
  }

  public void visitLiteralTypeExpr(@NotNull VdlLiteralTypeExpr o) {
    visitExpression(o);
  }

  public void visitLiteralValue(@NotNull VdlLiteralValue o) {
    visitCompositeElement(o);
  }

  public void visitMapType(@NotNull VdlMapType o) {
    visitType(o);
  }

  public void visitMethodDeclaration(@NotNull VdlMethodDeclaration o) {
    visitNamedElement(o);
  }

  public void visitMethodSpec(@NotNull VdlMethodSpec o) {
    visitNamedElement(o);
  }

  public void visitMulExpr(@NotNull VdlMulExpr o) {
    visitBinaryExpr(o);
  }

  public void visitOrExpr(@NotNull VdlOrExpr o) {
    visitBinaryExpr(o);
  }

  public void visitPackageClause(@NotNull VdlPackageClause o) {
    visitCompositeElement(o);
  }

  public void visitParType(@NotNull VdlParType o) {
    visitType(o);
  }

  public void visitParamDefinition(@NotNull VdlParamDefinition o) {
    visitCompositeElement(o);
  }

  public void visitParameterDeclaration(@NotNull VdlParameterDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitParameters(@NotNull VdlParameters o) {
    visitCompositeElement(o);
  }

  public void visitParenthesesExpr(@NotNull VdlParenthesesExpr o) {
    visitExpression(o);
  }

  public void visitPointerType(@NotNull VdlPointerType o) {
    visitType(o);
  }

  public void visitRangeClause(@NotNull VdlRangeClause o) {
    visitVarSpec(o);
  }

  public void visitReceiver(@NotNull VdlReceiver o) {
    visitCompositeElement(o);
  }

  public void visitReceiverType(@NotNull VdlReceiverType o) {
    visitType(o);
  }

  public void visitRecvStatement(@NotNull VdlRecvStatement o) {
    visitVarSpec(o);
  }

  public void visitReferenceExpression(@NotNull VdlReferenceExpression o) {
    visitExpression(o);
  }

  public void visitResult(@NotNull VdlResult o) {
    visitCompositeElement(o);
  }

  public void visitResultParameters(@NotNull VdlResultParameters o) {
    visitCompositeElement(o);
  }

  public void visitReturnStatement(@NotNull VdlReturnStatement o) {
    visitStatement(o);
  }

  public void visitSelectStatement(@NotNull VdlSelectStatement o) {
    visitStatement(o);
  }

  public void visitSelectorExpr(@NotNull VdlSelectorExpr o) {
    visitBinaryExpr(o);
  }

  public void visitSendStatement(@NotNull VdlSendStatement o) {
    visitStatement(o);
  }

  public void visitShortVarDeclaration(@NotNull VdlShortVarDeclaration o) {
    visitVarSpec(o);
  }

  public void visitSignature(@NotNull VdlSignature o) {
    visitCompositeElement(o);
  }

  public void visitSimpleStatement(@NotNull VdlSimpleStatement o) {
    visitStatement(o);
  }

  public void visitSpecType(@NotNull VdlSpecType o) {
    visitType(o);
  }

  public void visitStatement(@NotNull VdlStatement o) {
    visitCompositeElement(o);
  }

  public void visitStreamArgs(@NotNull VdlStreamArgs o) {
    visitCompositeElement(o);
  }

  public void visitStreamSpec(@NotNull VdlStreamSpec o) {
    visitCompositeElement(o);
  }

  public void visitStringLiteral(@NotNull VdlStringLiteral o) {
    visitExpression(o);
    // visitPsiLanguageInjectionHost(o);
  }

  public void visitStructType(@NotNull VdlStructType o) {
    visitType(o);
  }

  public void visitSwitchStart(@NotNull VdlSwitchStart o) {
    visitCompositeElement(o);
  }

  public void visitSwitchStatement(@NotNull VdlSwitchStatement o) {
    visitStatement(o);
  }

  public void visitTag(@NotNull VdlTag o) {
    visitCompositeElement(o);
  }

  public void visitTags(@NotNull VdlTags o) {
    visitCompositeElement(o);
  }

  public void visitType(@NotNull VdlType o) {
    visitCompositeElement(o);
  }

  public void visitTypeAssertionExpr(@NotNull VdlTypeAssertionExpr o) {
    visitExpression(o);
  }

  public void visitTypeCaseClause(@NotNull VdlTypeCaseClause o) {
    visitCompositeElement(o);
  }

  public void visitTypeDeclaration(@NotNull VdlTypeDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitTypeGuard(@NotNull VdlTypeGuard o) {
    visitCompositeElement(o);
  }

  public void visitTypeList(@NotNull VdlTypeList o) {
    visitType(o);
  }

  public void visitTypeReferenceExpression(@NotNull VdlTypeReferenceExpression o) {
    visitCompositeElement(o);
  }

  public void visitTypeSpec(@NotNull VdlTypeSpec o) {
    visitNamedElement(o);
  }

  public void visitTypeSwitchGuard(@NotNull VdlTypeSwitchGuard o) {
    visitCompositeElement(o);
  }

  public void visitTypeSwitchStatement(@NotNull VdlTypeSwitchStatement o) {
    visitSwitchStatement(o);
  }

  public void visitUnaryExpr(@NotNull VdlUnaryExpr o) {
    visitExpression(o);
  }

  public void visitUnionType(@NotNull VdlUnionType o) {
    visitType(o);
  }

  public void visitValue(@NotNull VdlValue o) {
    visitCompositeElement(o);
  }

  public void visitVarDeclaration(@NotNull VdlVarDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitVarDefinition(@NotNull VdlVarDefinition o) {
    visitCompositeElement(o);
  }

  public void visitVarSpec(@NotNull VdlVarSpec o) {
    visitCompositeElement(o);
  }

  public void visitAssignOp(@NotNull VdlAssignOp o) {
    visitCompositeElement(o);
  }

  public void visitNamedElement(@NotNull VdlNamedElement o) {
    visitCompositeElement(o);
  }

  public void visitCompositeElement(@NotNull VdlCompositeElement o) {
    visitElement(o);
  }

}
