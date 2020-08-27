package com.aaa.controller;

import com.aaa.service.MenuInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Map<String,Object>> getids(Integer did){
        return  menuInfoService.deptmune(did);
    }

    @RequestMapping("edit")
    public Integer edit(Integer did,Integer[] ids){
        try {
            menuInfoService.editPermission(did,ids);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
