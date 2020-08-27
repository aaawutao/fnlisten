package com.aaa.controller;


import com.aaa.entity.Programtypeinfo;
import com.aaa.service.ProgramtypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("programtypeinfo")
public class programtypeiController {

    @Resource
    ProgramtypeService programtypeService;

    @RequestMapping("selectType")
    public PageInfo<Programtypeinfo> findAll(Integer currentPage, Integer pageSize){
        System.out.println(currentPage+"   "+pageSize);
        return programtypeService.findAll(currentPage,pageSize);
    }
    @RequestMapping("addprotype")
    public int addprotype(Programtypeinfo programtypeinfo){
        return  programtypeService.addprotype(programtypeinfo);
    }

    @RequestMapping("deleteprotype")
    public int deleteprotype(Integer ptid){
        System.out.println(ptid);
        return programtypeService.deleteprotype(ptid);
    }
}
