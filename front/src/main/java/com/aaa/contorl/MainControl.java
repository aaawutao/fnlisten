package com.aaa.contorl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControl {


    @RequestMapping("/")
    public String show(){
        return "main.html";
    }
}
