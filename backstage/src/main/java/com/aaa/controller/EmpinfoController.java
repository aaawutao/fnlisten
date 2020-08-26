package com.aaa.controller;

import com.aaa.entity.Empinfo;
import com.aaa.service.EmpinfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("empinfo")
public class EmpinfoController {
    @Resource
    EmpinfoService empinfoService;

    @ResponseBody
    @RequestMapping("empinfoAll")
    public PageInfo<Empinfo> EmpinfoAll(Integer currentPage, Integer pageSize){
        return empinfoService.EmpinfoAll(currentPage,pageSize);
    }
    @ResponseBody
    @RequestMapping("add")
    public int add(Empinfo empinfo){
        return empinfoService.add(empinfo);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Empinfo empinfo){
        return empinfoService.update(empinfo);
    }
}
