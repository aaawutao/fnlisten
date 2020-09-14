package com.aaa.controller;

import com.aaa.service.TopupinfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("topupinfo")
public class TopupinfoController {

    @Resource
    TopupinfoService topupinfoService;

    //查询所有的用户充值记录
    @RequestMapping("querytopupi")
    public PageInfo<Map<String, Object>> querytopupi(Integer currentPage, Integer pageSize,String front_userphone){
        System.out.println(front_userphone);
        return topupinfoService.querytopupi(currentPage,pageSize,front_userphone);
    }

}
