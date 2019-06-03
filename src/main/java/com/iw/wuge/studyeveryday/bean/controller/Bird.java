package com.iw.wuge.studyeveryday.bean.controller;

import com.iw.wuge.agentReport.business.service.service.Flyable;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Author: tonggen
 * Date: 2019/5/27
 * time: 3:26 PM
 */
//@Slf4j
public class Bird implements Flyable{

    @Override
    public void fly() {
        System.out.println("wuge is a bird. base");

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        TimeProxy test = new TimeProxy(bird);
        test.fly();
    }
}
