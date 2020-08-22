package com.aaa.contorl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestControl {
    @RequestMapping("test")
    @ResponseBody
    public String show(){
        return "你好1245";
    }
}
