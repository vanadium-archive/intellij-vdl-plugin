// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.openapi.util.Comparing;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VdlVarProcessor extends VdlScopeProcessorBase {
    private final boolean myImShortVarDeclaration;
    private final PsiElement myParentGuard;
    @Nullable
    private final VdlCompositeElement myScope;

    public VdlVarProcessor(@NotNull PsiElement origin, boolean completion) {
        this(origin, origin, completion, false);
    }

    public VdlVarProcessor(@NotNull PsiElement requestedName, @NotNull PsiElement origin, boolean completion, boolean delegate) {
        super(requestedName, origin, completion);
        myImShortVarDeclaration = PsiTreeUtil.getParentOfType(origin, VdlShortVarDeclaration.class) != null && !delegate;
        myParentGuard = origin.getParent() instanceof VdlTypeSwitchGuard ? origin.getParent() : null;
        myScope = getScope(origin);
    }

    @Override
    protected boolean add(@NotNull VdlNamedElement o) {
        if (PsiTreeUtil.findCommonParent(o, myOrigin) instanceof VdlRangeClause) return true;
        PsiElement p = o.getParent();
        boolean inVarOrRange = PsiTreeUtil.getParentOfType(o, VdlVarDeclaration.class) != null || p instanceof VdlRangeClause;
        boolean differentBlocks = differentBlocks(o);
        boolean inShortVar = PsiTreeUtil.getParentOfType(o, VdlShortVarDeclaration.class, VdlRecvStatement.class) != null;
        if (inShortVar && differentBlocks && myImShortVarDeclaration) return true;
        if (differentBlocks && inShortVar && !inVarOrRange && getResult() != null && !myIsCompletion) return true;
        if (inShortVar && fromNotAncestorBlock(o)) return true;
        if (myParentGuard != null && o instanceof VdlVarDefinition && p.isEquivalentTo(myParentGuard)) return true;
        return super.add(o);
    }

    private boolean fromNotAncestorBlock(@NotNull VdlNamedElement o) {
        return (myScope instanceof VdlExprCaseClause || myScope instanceof VdlCommClause) &&
                !PsiTreeUtil.isAncestor(getScope(o), myOrigin, false);
    }

    private boolean differentBlocks(@Nullable VdlNamedElement o) {
        return !Comparing.equal(myScope, getScope(o));
    }

    @Nullable
    public static VdlCompositeElement getScope(@Nullable PsiElement o) {
        VdlForStatement forStatement = PsiTreeUtil.getParentOfType(o, VdlForStatement.class);
        if (forStatement != null) return forStatement.getBlock();
        VdlIfStatement ifStatement = PsiTreeUtil.getParentOfType(o, VdlIfStatement.class);
        if (ifStatement != null) return ifStatement.getBlock();
        VdlElseStatement elseStatement = PsiTreeUtil.getParentOfType(o, VdlElseStatement.class);
        if (elseStatement != null) return elseStatement.getBlock();
        VdlExprCaseClause exprCaseClause = PsiTreeUtil.getParentOfType(o, VdlExprCaseClause.class);
        if (exprCaseClause != null) return exprCaseClause;
        VdlCommClause commClause = PsiTreeUtil.getParentOfType(o, VdlCommClause.class);
        if (commClause != null) return commClause;
        return PsiTreeUtil.getParentOfType(o, VdlBlock.class);
    }

    protected boolean crossOff(@NotNull PsiElement e) {
        return !(e instanceof VdlVarDefinition) &&
                !(e instanceof VdlParamDefinition) &&
                !(e instanceof VdlFieldDefinition) &&
                !(e instanceof VdlAnonymousFieldDefinition) &&
                !(e instanceof VdlConstDefinition);
    }

}
