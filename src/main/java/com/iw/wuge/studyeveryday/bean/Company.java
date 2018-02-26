package com.iw.wuge.studyeveryday.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Company {
    private Integer id;
    private String companyName;
    private Date startTime;

    public Company(Integer id, String companyName, Date startTime) {
        this.id = id;
        this.companyName = companyName;
        this.startTime = startTime;
    }
}
