package com.iw.wuge.blog;


import com.iw.wuge.blog.init.TaleLoader;

import static com.blade.Blade.$;

public class Application {

    public static void main(String[] args) throws Exception {
        TaleLoader.init();
        $().start(Application.class);
    }

}