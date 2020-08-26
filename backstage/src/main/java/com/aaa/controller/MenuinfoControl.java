package com.aaa.controller;

import com.aaa.service.MenuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuinfoControl {
    @Resource
    MenuInfoService menuInfoService;

    @RequestMapping("menushow")
    public List<Map<String,Object>> menushow(){
        return menuInfoService.all();
    }
    @RequestMapping("getids")
    public Integer[] getids(Integer did){
        return  menuInfoService.deptmune(did);
    }

}
