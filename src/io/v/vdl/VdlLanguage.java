package io.v.vdl;

import com.intellij.lang.Language;

public class VdlLanguage extends Language {
    public static final VdlLanguage INSTANCE = new VdlLanguage();

    private VdlLanguage() {
        super("VDL");
    }
}
