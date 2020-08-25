package com.aaa.controller;

import com.aaa.entity.Topupsetinfo;
import com.aaa.service.TopupsetinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Topupsetinfo")
public class TopupsetinfoController {
    @Resource
    TopupsetinfoService topupsetinfoService;
    @ResponseBody
    @RequestMapping("TopupsetinfoAll")
    public List<Topupsetinfo> TopupsetinfoAll(){
        System.out.println("TopupsetinfoAll");
        return topupsetinfoService.TopupsetinfoAll();
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
