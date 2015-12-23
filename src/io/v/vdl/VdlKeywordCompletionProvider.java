// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.PrioritizedLookupElement;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VdlKeywordCompletionProvider extends CompletionProvider<CompletionParameters> {
    private final int myPriority;
    @Nullable
    private final InsertHandler<LookupElement> myInsertHandler;
    @Nullable private final AutoCompletionPolicy myCompletionPolicy;
    @NotNull
    private final String[] myKeywords;

    public VdlKeywordCompletionProvider(int priority, String... keywords) {
        this(priority, null, null, keywords);
    }

    public VdlKeywordCompletionProvider(int priority, @Nullable AutoCompletionPolicy completionPolicy, @NotNull String... keywords) {
        this(priority, null, completionPolicy, keywords);
    }

    public VdlKeywordCompletionProvider(int priority,
                                       @Nullable InsertHandler<LookupElement> insertHandler,
                                       @Nullable AutoCompletionPolicy completionPolicy,
                                       @NotNull String... keywords) {
        myPriority = priority;
        myInsertHandler = insertHandler;
        myCompletionPolicy = completionPolicy;
        myKeywords = keywords;
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
        for (String keyword : myKeywords) {
            result.addElement(createKeywordLookupElement(keyword));
        }
    }

    @NotNull
    private LookupElement createKeywordLookupElement(@NotNull String keyword) {
        LookupElement result = createKeywordLookupElement(keyword, myPriority, myInsertHandler);
        return myCompletionPolicy != null ? myCompletionPolicy.applyPolicy(result) : result;
    }

    public static LookupElement createKeywordLookupElement(@NotNull String keyword,
                                                           int priority,
                                                           @Nullable InsertHandler<LookupElement> insertHandler) {
        LookupElementBuilder builder = LookupElementBuilder.create(keyword).withBoldness(true).withInsertHandler(insertHandler);
        return PrioritizedLookupElement.withPriority(builder, priority);
    }
}
