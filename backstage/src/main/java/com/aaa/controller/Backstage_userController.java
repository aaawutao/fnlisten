package com.aaa.controller;

import com.aaa.entity.Backstage_User;
import com.aaa.service.Backstage_UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class Backstage_userController {

    @Resource
    Backstage_UserService backstage_userService;


}
