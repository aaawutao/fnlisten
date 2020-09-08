package com.aaa.contorl;

import com.aaa.entity.FrontUser;
import com.aaa.service.FrontUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("frontuser")
public class FrontUserControl {
    @Resource
    FrontUserService frontUserService;

    @RequestMapping("getxunibi")
    @ResponseBody
    public Integer getxunibi(Integer front_userid){
        return frontUserService.getxunibi(front_userid);
    }
}
