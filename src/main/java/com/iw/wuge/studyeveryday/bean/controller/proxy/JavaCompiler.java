package com.iw.wuge.studyeveryday.bean.controller.proxy;

import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;

/**
 * Author: tonggen
 * Date: 2019/5/27
 * time: 6:13 PM
 */
public class JavaCompiler {

    public static void compile(File javaFile) throws IOException {
        javax.tools.JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null,null,null);
        Iterable iterable = fileManager.getJavaFileObjects(javaFile);
        javax.tools.JavaCompiler.CompilationTask task =
                javaCompiler.getTask(null,fileManager,null,null,null,iterable);
        task.call();
        fileManager.close();
    }
}
