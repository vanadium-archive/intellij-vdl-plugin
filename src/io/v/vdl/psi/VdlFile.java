// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.vdl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.Conditions;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubTree;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayFactory;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.MultiMap;
import io.v.vdl.VdlFileType;
import io.v.vdl.VdlLanguage;
import io.v.vdl.VdlUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VdlFile extends PsiFileBase {
    public VdlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, VdlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return VdlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "VDL file";
    }

    public List<VdlTypeSpec> getTypes() {
        StubElement<VdlFile> stub = getStub();
        if (stub != null) return getChildrenByType(stub, VdlTypes.TYPE_SPEC, VdlTypeSpecStubElementType.ARRAY_FACTORY);

        return CachedValuesManager.getCachedValue(this, new CachedValueProvider<List<VdlTypeSpec>>() {
            @Override
            public Result<List<VdlTypeSpec>> compute() {
                return Result.create(calcTypes(), VdlFile.this);
            }
        });
    }

    @NotNull
    private List<VdlTypeSpec> calcTypes() {
        final List<VdlTypeSpec> result = ContainerUtil.newArrayList();
        processChildrenDummyAware(this, new Processor<PsiElement>() {
            @Override
            public boolean process(PsiElement e) {
                if (e instanceof VdlTypeDeclaration) {
                    for (VdlTypeSpec spec : ((VdlTypeDeclaration)e).getTypeSpecList()) {
                        result.add(spec);
                    }
                }
                return true;
            }
        });
        return result;
    }

    @NotNull
    private static <E extends PsiElement> List<E> getChildrenByType(@NotNull StubElement<? extends PsiElement> stub,
                                                                    IElementType elementType,
                                                                    ArrayFactory<E> f) {
        return Arrays.asList(stub.getChildrenByType(elementType, f));
    }

    @Nullable
    @Override
    public VdlFileStub getStub() {
        //noinspection unchecked
        return (VdlFileStub)super.getStub();
    }

    @Nullable
    public VdlPackageClause getPackage() {
        VdlFileStub stub = getStub();
        if (stub != null) {
            String name = stub.getPackageName();
            return name != null ? VdlElementFactory.createPackageClause(stub.getProject(), name) : null;
        }
        return CachedValuesManager.getCachedValue(this, new CachedValueProvider<VdlPackageClause>() {
            @Override
            public Result<VdlPackageClause> compute() {
                VdlPackageClause packageClauses = calcFirst(Conditions.<PsiElement>instanceOf(VdlPackageClause.class));
                return Result.create(packageClauses, VdlFile.this);
            }
        });
    }

    @Nullable
    private <T extends PsiElement> T calcFirst(@NotNull final Condition<PsiElement> condition) {
        final Ref<T> result = Ref.create(null);
        processChildrenDummyAware(this, new Processor<PsiElement>() {
            @Override
            public boolean process(PsiElement e) {
                if (condition.value(e)) {
                    //noinspection unchecked
                    result.set((T)e);
                    return false;
                }
                return true;
            }
        });
        return result.get();
    }

    private static boolean processChildrenDummyAware(@NotNull VdlFile file, @NotNull final Processor<PsiElement> processor) {
        StubTree stubTree = file.getStubTree();
        if (stubTree != null) {
            List<StubElement<?>> plainList = stubTree.getPlainList();
            for (StubElement<?> stubElement : plainList) {
                PsiElement psi = stubElement.getPsi();
                if (!processor.process(psi)) return false;
            }
            return true;
        }
        return new Processor<PsiElement>() {
            @Override
            public boolean process(@NotNull PsiElement psiElement) {
                for (PsiElement child = psiElement.getFirstChild(); child != null; child = child.getNextSibling()) {
                    if (child instanceof GeneratedParserUtilBase.DummyBlock) {
                        if (!process(child)) return false;
                    }
                    else if (!processor.process(child)) return false;
                }
                return true;
            }
        }.process(file);
    }


    @Nullable
    public String getPackageName() {
        VdlFileStub stub = getStub();
        if (stub != null) return stub.getPackageName();
        VdlPackageClause packageClause = getPackage();
        return packageClause != null ? packageClause.getName() : null;
    }

    @NotNull
    public List<VdlVarDefinition> getVars() {
        StubElement<VdlFile> stub = getStub();
        if (stub != null) {
            List<VdlVarDefinition> result = ContainerUtil.newArrayList();
            List<VdlVarSpec> varSpecs = getChildrenByType(stub, VdlTypes.VAR_SPEC, VdlVarSpecStubElementType.ARRAY_FACTORY);
            for (VdlVarSpec spec : varSpecs) {
                VdlVarSpecStub specStub = spec.getStub();
                if (specStub == null) continue;
                result.addAll(getChildrenByType(specStub, VdlTypes.VAR_DEFINITION, VdlVarDefinitionStubElementType.ARRAY_FACTORY));
            }
            return result;
        }
        return CachedValuesManager.getCachedValue(this, new CachedValueProvider<List<VdlVarDefinition>>() {
            @Override
            public Result<List<VdlVarDefinition>> compute() {
                return Result.create(calcVars(), VdlFile.this);
            }
        });
    }

    @NotNull
    private List<VdlVarDefinition> calcVars() {
        final List<VdlVarDefinition> result = ContainerUtil.newArrayList();
        processChildrenDummyAware(this, new Processor<PsiElement>() {
            @Override
            public boolean process(PsiElement e) {
                if (e instanceof VdlVarDeclaration) {
                    for (VdlVarSpec spec : ((VdlVarDeclaration)e).getVarSpecList()) {
                        for (VdlVarDefinition def : spec.getVarDefinitionList()) {
                            result.add(def);
                        }
                    }
                }
                return true;
            }
        });
        return result;
    }

    /**
     * @return map like { local package name, maybe alias -> import spec } for file
     */
    @NotNull
    public MultiMap<String, VdlImportSpec> getImportMap() {
        MultiMap<String, VdlImportSpec> map = MultiMap.createLinked();
        for (VdlImportSpec spec : getImports()) {
            String alias = spec.getAlias();
            if (alias != null) {
                map.putValue(alias, spec);
                continue;
            }
            if (spec.isDot()) {
                map.putValue(".", spec);
                continue;
            }
            VdlImportString string = spec.getImportString();
            PsiDirectory dir = string.resolve();
            Collection<String> packagesInDirectory = VdlUtil.getAllPackagesInDirectory(dir, true);
            if (!packagesInDirectory.isEmpty()) {
                for (String packageNames : packagesInDirectory) {
                    if (!StringUtil.isEmpty(packageNames)) {
                        map.putValue(packageNames, spec);
                    }
                }
            }
            else {
                String key = spec.getLocalPackageName();
                if (!StringUtil.isEmpty(key)) {
                    map.putValue(key, spec);
                }
            }
        }
        return map;
    }

    @NotNull
    public List<VdlImportSpec> getImports() {
        StubElement<VdlFile> stub = getStub();
        if (stub != null) return getChildrenByType(stub, VdlTypes.IMPORT, VdlImportSpecStubElementType.ARRAY_FACTORY);
        return CachedValuesManager.getCachedValue(this, new CachedValueProvider<List<VdlImportSpec>>() {
            @Override
            public Result<List<VdlImportSpec>> compute() {
                return Result.create(calcImports(), VdlFile.this);
            }
        });
    }

    @NotNull
    private List<VdlImportSpec> calcImports() {
        List<VdlImportSpec> result = ContainerUtil.newArrayList();
        VdlImportList list = getImportList();
        if (list == null) return ContainerUtil.emptyList();
        for (VdlImportDeclaration declaration : list.getImportDeclarationList()) {
            for (VdlImportSpec spec : declaration.getImportSpecList()) {
                result.add(spec);
            }
        }
        return result;
    }

    @Nullable
    public VdlImportList getImportList() {
        return findChildByClass(VdlImportList.class);
    }
}
