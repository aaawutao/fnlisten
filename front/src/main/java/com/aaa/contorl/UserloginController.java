package com.aaa.contorl;

import com.aaa.entity.FrontUser;
import com.aaa.service.FrontUserService;
import com.aaa.util.AddSmsSign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Controller
@RestController
@RequestMapping("userlogin")
public class UserloginController {

    @Resource
    FrontUserService frontUserService;

    @RequestMapping("phoneCheck")
    public Map<String,Object> phoneCheck(String phone){
        Map<String, Object> map = AddSmsSign.contextLoads(phone);
        return map;
    }
    //注册账号
    @RequestMapping("addFrontuser")
    public int addFrontuser(FrontUser frontuser){
        frontuser.setFront_usercreatedate(new Date());
        frontuser.setFront_userstate(0);
        frontuser.setFlag(1);
        return frontUserService.addFrontuser(frontuser);
    }

}
