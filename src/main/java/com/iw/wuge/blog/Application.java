package com.iw.wuge.blog;


import com.iw.wuge.blog.init.TaleLoader;
import com.manyi.iw.uum.soa.model.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.blade.Blade.$;

public class Application{

    public static void main(String[] args) throws Exception {


    }

}

class Tag {
    Tag(int test) {
        System.out.println("sub的值：" + test);
    }
}

class Card {
    Tag t1 = new Tag(1);

    Card() {
        System.out.println("Card()");
        new Tag(333);
    }
    Tag t2 = new Tag(2);
    void f() {
        System.out.println("f()");
    }
    Tag t3 = new Tag(3);
}