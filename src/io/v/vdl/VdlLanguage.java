// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.lang.Language;

public class VdlLanguage extends Language {
    public static final VdlLanguage INSTANCE = new VdlLanguage();

    private VdlLanguage() {
        super("VDL");
    }
}
