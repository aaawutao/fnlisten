package com.aaa.contorl;


import com.aaa.entity.FrontUser;
import com.aaa.service.FrontUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

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

    //修改个人信息
    @ResponseBody
    @RequestMapping("updates")
    public Integer updateDate(Integer front_userid){
        return frontUserService.updateDate(front_userid);
    }

    @RequestMapping("queryname")
    @ResponseBody
    public String queryname(HttpSession session){
        Map map=(Map)session.getAttribute("user");
        return frontUserService.queryByuserId(Integer.parseInt(map.get("front_userid").toString())).getFront_username();
    }
}
