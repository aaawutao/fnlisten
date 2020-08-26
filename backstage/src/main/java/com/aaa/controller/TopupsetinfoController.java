package com.aaa.controller;

import com.aaa.entity.Topupsetinfo;
import com.aaa.service.TopupsetinfoService;
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
@RequestMapping("topupsetinfo")
public class TopupsetinfoController {
    @Resource
    TopupsetinfoService topupsetinfoService;
    @ResponseBody
    @RequestMapping("topupsetinfoAll")
    public PageInfo<Topupsetinfo> TopupsetinfoAll(Integer currentPage, Integer pageSize){
        return topupsetinfoService.TopupsetinfoAll(currentPage,pageSize);
    }
    @RequestMapping("add")
    @ResponseBody
    public int add(@RequestBody Topupsetinfo topupsetinfo){
        System.out.println(topupsetinfo);
        return topupsetinfoService.add(topupsetinfo);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(@RequestBody Topupsetinfo topupsetinfo){
        return topupsetinfoService.update(topupsetinfo);
    }
}
