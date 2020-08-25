package com.aaa.controller;


import com.aaa.entity.Departmentinfo;
import com.aaa.service.DepartmentinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Departmentinfo")
public class DepartmentinfoController {
    @Resource
    DepartmentinfoService departmentinfoService;

    @ResponseBody
    @RequestMapping("DepartmentinfoAll")
    public List<Departmentinfo>DepartmentinfoAll(){
        System.out.println("DepartmentinfoAll");
        return departmentinfoService.DepartmentinfoAll();
    }
    @RequestMapping("add")
    @ResponseBody
    public int add(@RequestBody Departmentinfo departmentinfo){
        System.out.println(departmentinfo);
        return departmentinfoService.add(departmentinfo);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(@RequestBody Departmentinfo departmentinfo){
        return departmentinfoService.update(departmentinfo);
    }
}
