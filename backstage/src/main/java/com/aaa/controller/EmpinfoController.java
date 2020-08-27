package com.aaa.controller;

import com.aaa.entity.Empinfo;
import com.aaa.service.EmpinfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("empinfo")
public class EmpinfoController {
    @Resource
    EmpinfoService empinfoService;

    @RequestMapping("empinfoAll")
    public PageInfo<Empinfo> EmpinfoAll(Integer currentPage, Integer pageSize){
        return empinfoService.EmpinfoAll(currentPage,pageSize);
    }
    @RequestMapping("add")
    public int add(@RequestBody Empinfo empinfo){
        return empinfoService.add(empinfo);
    }

    @RequestMapping("update")
    public int update(@RequestBody Empinfo empinfo){
        return empinfoService.update(empinfo);
    }

    //查询没有分配账号的用户
    @RequestMapping("queryByDid")
    public List<Empinfo> queryByDid(){
        return empinfoService.queryByDid();
    }


}
