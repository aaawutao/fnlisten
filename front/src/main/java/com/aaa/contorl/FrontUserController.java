package com.aaa.contorl;


import com.aaa.entity.FrontUser;
import com.aaa.service.FrontUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("frontuser")
public class FrontUserController {

    @Resource
    FrontUserService frontUserService;

    //查询出个人信息
    @ResponseBody
    @RequestMapping("queryByuserId")
    public Object queryByuserId(Model model , Integer front_userid){
        /*System.out.println(front_userid);
        FrontUser frontUser = frontUserService.queryByuserId(front_userid);
        model.addAttribute("list",frontUser);*/
        return  frontUserService.queryByuserId(front_userid);
    }
}
