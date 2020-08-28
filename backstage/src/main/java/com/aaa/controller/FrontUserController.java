package com.aaa.controller;

import com.aaa.entity.FrontUser;
import com.aaa.service.FrontUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("frontuser")
public class FrontUserController {

    @Resource
    FrontUserService frontUserService;
    @RequestMapping("frontUserfindAll")
    public PageInfo<FrontUser> frontUserfindAll(Integer currentPage, Integer pageSize){
        return frontUserService.findAll(currentPage, pageSize);
    }
}
