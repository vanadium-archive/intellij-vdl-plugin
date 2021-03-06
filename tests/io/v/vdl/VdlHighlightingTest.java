// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.DefaultLightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class VdlHighlightingTest extends LightPlatformCodeInsightFixtureTestCase {
    @Override
    protected final String getTestDataPath() {
        return new File("testData/" + getBasePath()).getAbsolutePath();
    }

    private void doTest() {
        myFixture.testHighlighting(true, false, false, getTestName(true) + ".vdl");
    }

    public void testErrors() { doTest(); }
    public void testFortune() { doTest(); }
    public void testOptional() { doTest(); }

    @Override
    protected LightProjectDescriptor getProjectDescriptor() {
        return createMockProjectDescriptor();
    }

    @NotNull
    protected static DefaultLightProjectDescriptor createMockProjectDescriptor() {
        return new DefaultLightProjectDescriptor() {
        };
    }


    @Override
    protected boolean isWriteActionRequired() {
        return false;
    }
}