package com.aaa.controller;

import com.aaa.entity.Backstage_User;
import com.aaa.service.Backstage_UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
public class Backstage_userController {

    @Resource
    Backstage_UserService backstage_userService;

    @RequestMapping("findAll")
    public  PageInfo<Backstage_User> findAll(Integer currentPage,Integer pageSize){
        return backstage_userService.findAll(currentPage,pageSize);
    }
    @RequestMapping("updateFlag")
    public int updateFlag(Integer isenable,Integer backstage_userid){
        return backstage_userService.updateFlag(isenable,backstage_userid);
    }

}
