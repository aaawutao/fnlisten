package com.aaa.contorl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControl {


    @RequestMapping("/main")
    public String show(){
        return "main.html";
    }

    @RequestMapping("/test")
    public String show2(){ return "listen.html";}
}
