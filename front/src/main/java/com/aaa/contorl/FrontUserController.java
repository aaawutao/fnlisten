package com.aaa.contorl;


import com.aaa.entity.FrontUser;
import com.aaa.service.FrontUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("frontuser")
public class FrontUserController {

    @Resource
    FrontUserService frontUserService;

    //查询出个人信息
    @ResponseBody
    @RequestMapping("queryByuserId")
    public FrontUser queryByuserId(Integer front_userid){
        return  frontUserService.queryByuserId(front_userid);
    }
}
