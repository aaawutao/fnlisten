package com.aaa.controller;


import com.aaa.entity.Programtypeinfo;
import com.aaa.service.ProgramtypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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
        Integer ptid = programtypeinfo.getPtid();
        if(ptid==null){
            return programtypeService.addprotype(programtypeinfo);
        }else{
            return programtypeService.updateprotype(programtypeinfo);
        }

    }

    @RequestMapping("deleteprotype")
    public int deleteprotype(Integer ptid){
        return programtypeService.deleteprotype(ptid);
    }


}
