package com.aaa.contorl;

import com.aaa.service.AnchorinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

@Controller
@RequestMapping("anchorinfo")
public class AnchorinfoController {
    @Resource
    AnchorinfoService anchorinfoService;

    @ResponseBody
    @RequestMapping("addanchor")
    public int addanchor(Integer front_userid, String petname) {
        System.out.println(front_userid);
        System.out.println(petname);
        return anchorinfoService.addanchor(front_userid, petname);
    }
}
