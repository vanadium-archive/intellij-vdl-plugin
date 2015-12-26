// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.LayeredIcon;
import com.intellij.util.PlatformIcons;

import javax.swing.*;

public interface VdlIcons {
    Icon FILE = IconLoader.getIcon("/icons/v-icon.png");
    Icon TYPE = IconLoader.findIcon("/icons/type.png");
    Icon METHOD = AllIcons.Nodes.Method;
    Icon FUNCTION = AllIcons.Nodes.Function;
    Icon VARIABLE = AllIcons.Nodes.Variable;
    Icon CONSTANT = new LayeredIcon(AllIcons.Nodes.Field, AllIcons.Nodes.FinalMark);
    Icon PARAMETER = AllIcons.Nodes.Parameter;
    Icon FIELD = AllIcons.Nodes.Field;
}
