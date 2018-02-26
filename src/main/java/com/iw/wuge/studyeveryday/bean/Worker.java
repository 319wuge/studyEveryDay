package com.iw.wuge.studyeveryday.bean;

import lombok.Data;

@Data
public class Worker {
    private Integer id;
    private String workYear;
    private Integer age;
    private String name;
    public Worker(Integer id , String workYear, Integer age, String name) {
        this.id = id;
        this.workYear = workYear;
        this.age = age;
        this.name = name;
    }
}
