package com.iw.wuge.studyeveryday.bean.controller;

import com.iw.wuge.agentReport.business.service.service.Flyable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: tonggen
 * Date: 2019/6/4
 * time: 2:13 PM
 */
public class LogPrintlnProxy implements Flyable{

    private InvocationHandler handler;

    public LogPrintlnProxy(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void fly() {
        try {
            Method method = com.iw.wuge.agentReport.business.service.service.Flyable.class.getMethod("fly");
            this.handler.invoke(this,method,null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
