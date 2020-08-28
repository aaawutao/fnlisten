package com.aaa.controller;


import com.aaa.entity.Programinfo;
import com.aaa.service.PrograminfoService;
import com.aaa.service.ProgramtypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("programinfo")
public class PrograminfoController {

    @Resource
    PrograminfoService programinfoService;

    @RequestMapping("programinfoAll")
    public PageInfo<List<Map<String, Object>>> findAll(Integer currentPage, Integer pageSize,Integer pid){
        return programinfoService.queryAll(currentPage,pageSize,pid);
    }


}
