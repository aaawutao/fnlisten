package com.aaa.contorl;

import com.aaa.service.AnchorinfoService;
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

    @ResponseBody
    @RequestMapping("addanchor")
    public int addanchor(Integer front_userid, String petname, HttpSession session) {
        System.out.println(front_userid);
        System.out.println(petname);
        Map user=(Map)session.getAttribute("user");
        //覆盖
        user.put("front_userflag",2);
        session.setAttribute("user",user);
        return anchorinfoService.addanchor(front_userid, petname);
    }


}
