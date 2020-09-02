package com.aaa.contorl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainControl {


    @RequestMapping("/main")
    public String show(){
        return "main.html";
    }

    @RequestMapping("/test")
    public String show2(){ return "login.html";}

    @RequestMapping("/xianqing")
    public String xinqing(){
        return "xianqing::iframe_a";
    }

    @RequestMapping("/context")
    public String context(){
        System.out.println("局部刷新");
        return "login::div1";
    }
}
