package com.aaa.controller;


import com.aaa.entity.Departmentinfo;
import com.aaa.service.DepartmentinfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("departmentinfo")
public class DepartmentinfoController {
    @Resource
    DepartmentinfoService departmentinfoService;

    @RequestMapping("departmentinfoAll")
    public PageInfo<Departmentinfo> findAll(Integer currentPage, Integer pageSize){

        return departmentinfoService.findAll(currentPage,pageSize);
    }
    @RequestMapping("add")
    public int addprotype(Departmentinfo departmentinfo){
        Integer did = departmentinfo.getDid();
        if(did==null){
            return departmentinfoService.addprotype(departmentinfo);
        }else{
            return departmentinfoService.updateprotype(departmentinfo);
        }

    }
    @RequestMapping("delete")
    public int deleteprotype(Integer did){
        return departmentinfoService.deleteprotype(did);
    }
}
