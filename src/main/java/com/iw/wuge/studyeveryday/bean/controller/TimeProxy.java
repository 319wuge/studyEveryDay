package com.iw.wuge.studyeveryday.bean.controller;

import com.iw.wuge.agentReport.business.service.service.Flyable;

/**
 * Author: tonggen
 * Date: 2019/5/27
 * time: 3:40 PM
 */
public class TimeProxy implements Flyable{

    private Flyable flyable;
    public TimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("fly time is " + String.valueOf(end - start));
    }
}
