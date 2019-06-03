package com.iw.wuge.studyeveryday.bean.controller.proxy;

import com.iw.wuge.agentReport.business.service.service.Flyable;
import com.iw.wuge.studyeveryday.bean.controller.Bird;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Author: tonggen
 * Date: 2019/5/27
 * time: 5:46 PM
 */
public class Proxy {

// https://blog.csdn.net/u014589856/article/details/79551155
    public static Object newProxyInstance() throws IOException {

        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy").addModifiers(Modifier.PUBLIC)
                .addSuperinterface(Flyable.class);
        FieldSpec fieldSpec = FieldSpec.builder(Flyable.class, "flyable", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
                .addParameter(Flyable.class, "flyable")
                .addStatement("this.flyable = flyable")
                .build();
        typeSpecBuilder.addMethod(constructorMethodSpec);

        Method[] methods = Flyable.class.getDeclaredMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addStatement("long start = $T.currentTimeMillis()", System.class)
                    .addCode("\n")
                    .addStatement("this.flyable." + method.getName() + "()")
                    .addCode("\n")
                    .addStatement("long end = $T.currentTimeMillis()", System.class)
                    .addStatement("$T.out.println(\"Fly Time =\" + (end - start))", System.class)
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }
        JavaFile javaFile = JavaFile.builder("com.iw.wuge.studyeveryday.bean.controller.proxy", typeSpecBuilder.build()).build();
        javaFile.writeTo(new File("/Users/wuge/java/temp"));

        // 编译
        JavaCompiler.compile(new File("/Users/wuge/java/temp" + "/com/iw/wuge/studyeveryday/bean/controller/proxy/TimeProxy.java"));

        return null;
    }

    public static void main(String[] args) throws IOException {
        Proxy.newProxyInstance();

        URL[] urls = new URL[] {new URL("file:/" + "Users/wuge/java/temp/")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        try {
            Class clazz = classLoader.loadClass("com.iw.wuge.studyeveryday.bean.controller.proxy.TimeProxy");
            try {
                Constructor constructor = clazz.getConstructor(Flyable.class);
                try {
//                    constructor.setAccessible(true);
                    Flyable  flyable = (Flyable) constructor.newInstance(new Bird());
                    flyable.fly();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
