package com.iw.wuge.blog.controller;

import com.iw.wuge.blog.Application;
import com.iw.wuge.blog.init.TaleLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static com.blade.Blade.$;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
@Controller
public class StartController {

    @RequestMapping(value = "index2.do")
    public void startIt(HttpServletRequest request) {
        TaleLoader.init(request);
        $().start(Application.class);
    }
}
