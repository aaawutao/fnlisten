package com.aaa.contorl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControl {


    @RequestMapping("/main")
    public String show(){
        return "main.html";
    }

    @RequestMapping("/test")
    public String show2(){ return "listen.html";}

    @RequestMapping("/xianqing")
    public String xinqing(){
        return "xianqing.html::iframe_a";
    }
    @RequestMapping("/context")
    public String context(){
        return "context.html::iframe_a";
    }
}
