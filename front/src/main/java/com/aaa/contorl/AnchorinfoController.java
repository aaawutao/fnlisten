package com.aaa.contorl;

import com.aaa.service.AnchorinfoService;
import com.aaa.service.FrontUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("anchorinfo")
public class AnchorinfoController {
    @Resource
    AnchorinfoService anchorinfoService;
    @Resource
    FrontUserService frontUserService;

    @ResponseBody
    @RequestMapping("addanchor")
    public int addanchor(Integer front_userid, String petname, HttpSession session) {
        //添加主播编号
        Integer res=anchorinfoService.addanchor(front_userid, petname);
        Map user=(Map)session.getAttribute("user");
        user=frontUserService.login(user.get("front_userphone").toString(),user.get("front_userpwd").toString());
        session.setAttribute("user",user);
        return res;
    }
}
