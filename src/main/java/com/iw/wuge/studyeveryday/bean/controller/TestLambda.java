package com.iw.wuge.studyeveryday.bean.controller;

import com.iw.wuge.studyeveryday.bean.Company;
import com.iw.wuge.studyeveryday.bean.Worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
//        workers.forEach(System.out :: println);

//        Predicate<Worker> contion1 = n -> n.getName().endsWith("3");
//        Predicate<Worker> contion2 = e -> e.getAge().equals(24);
//        workers.stream().filter(contion1.or(contion2)).forEach(e -> System.out.println(e.getName()));

//        workers.stream().map(e -> e.getAge() + 1).forEach(System.out :: println);

//        List<Worker> newList = workers.stream().map(e -> new Worker(e.getId() + 1, e.getWorkYear(), e.getAge(), e.getName()))
//                .collect(Collectors.toList());
//        newList.forEach(System.out :: println);
        workers.stream().forEach(elem-> elem.setAge(123));
        System.out.println(workers);

//        Integer total = workers.stream().map(e -> e.getAge()).reduce((sum, e) -> sum + e).get();
//        System.out.println(total);

//        workers.stream().filter(e -> e.getAge().equals(23));
//        workers.forEach(System.out :: println);

//        String str = workers.stream().map(e -> e.getName().toUpperCase()).collect(Collectors.joining(","));
//        System.out.println(str);

//        workers.stream().map(Worker :: getAge).distinct().forEach(System.out :: println);

//        IntSummaryStatistics start = workers.stream().mapToInt(Worker :: getAge).summaryStatistics();
//        System.out.println(start.getAverage());
//        System.out.println(start.getCount());
//        System.out.println(start.getMax());
//        System.out.println(start.getSum());
//        Executors.newSingleThreadExecutor();

//Integer a = 1;
//Integer b = a;
//Integer c = a;
//        System.out.println(c == b);

    }

}
