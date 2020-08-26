package com.aaa.controller;


import com.aaa.entity.Departmentinfo;
import com.aaa.service.DepartmentinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("departmentinfo")
public class DepartmentinfoController {
    @Resource
    DepartmentinfoService departmentinfoService;

    @ResponseBody
    @RequestMapping("departmentinfoAll")
    public List<Departmentinfo> DepartmentinfoAll(){
        return departmentinfoService.DepartmentinfoAll();
    }
    @RequestMapping("add")
    @ResponseBody
    public int add(Departmentinfo departmentinfo){
        System.out.println(departmentinfo);
        return departmentinfoService.add(departmentinfo);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Departmentinfo departmentinfo){
        return departmentinfoService.update(departmentinfo);
    }
}
