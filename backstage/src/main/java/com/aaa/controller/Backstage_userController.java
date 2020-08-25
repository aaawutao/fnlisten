package com.aaa.controller;

import com.aaa.entity.Backstage_User;
import com.aaa.service.Backstage_UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
public class Backstage_userController {

    @Resource
    Backstage_UserService backstage_userService;

    @RequestMapping("test")
    public String test(){
        System.out.println("1111111111111111");
        return "ok";
    }
    @RequestMapping("findAll")
    public  PageInfo<Backstage_User> findAll(Integer currentPage,Integer pageSize){
        /*System.out.println(map);
        Integer pageNum = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");*/
        System.out.println(currentPage);
        return backstage_userService.findAll(currentPage,pageSize);
    }

}
