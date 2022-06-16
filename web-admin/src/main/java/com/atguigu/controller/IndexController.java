package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 孙消飞
 * @version 1.0
 */
@Controller
public class IndexController {
    private static final String PAGE_INDEX = "frame/index";
    private static final String PAGE_MAIN = "frame/main";

    @GetMapping
    public String index(){
        return PAGE_INDEX;
    }

    @GetMapping("/main")
    public String main(){
        return PAGE_MAIN;
    }
}
