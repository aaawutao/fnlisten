package com.aaa.controller;

import com.aaa.entity.Empinfo;
import com.aaa.service.EmpinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Empinfo")
public class EmpinfoController {
    @Resource
    EmpinfoService empinfoService;

    @ResponseBody
    @RequestMapping("EmpinfoAll")
    public List<Empinfo> EmpinfoAll(){
        System.out.println("EmpinfoAll");
        return empinfoService.EmpinfoAll();
    }
    @ResponseBody
    @RequestMapping("add")
    public int add(@RequestBody Empinfo empinfo){
        return empinfoService.add(empinfo);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(@RequestBody Empinfo empinfo){
        return empinfoService.update(empinfo);
    }
}
