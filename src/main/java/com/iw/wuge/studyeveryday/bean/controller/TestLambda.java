package com.iw.wuge.studyeveryday.bean.controller;

import com.iw.wuge.studyeveryday.bean.Company;
import com.iw.wuge.studyeveryday.bean.Worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestLambda {
    public static void main(String[] args) {

        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker(1,"1", 24, "wuge1"));
        workers.add(new Worker(2,"2", 22, "wuge2"));
        workers.add(new Worker(3,"3", 23, "wuge3"));

        List<Company> companys = new ArrayList<>();
        companys.add(new Company(1,"uanguang1",new Date()));
        companys.add(new Company(2,"uanguang2",new Date()));
        companys.add(new Company(3,"uanguang3",new Date()));

//        workers.stream().filter(elem -> Collections.sort(elem))
    }
}
