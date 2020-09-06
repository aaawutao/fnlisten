package com.aaa.contorl;

import com.aaa.entity.FrontUser;
import com.aaa.service.FrontUserService;
import com.aaa.util.AddSmsSign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        frontuser.setFront_userflag(1);
        frontuser.setFlag(1);
        return frontUserService.addFrontuser(frontuser);
    }

    @RequestMapping("login")
    public Integer login(@RequestParam("phone") String phone, @RequestParam("pwd") String pwd, HttpServletRequest request,HttpSession session){
        request.getSession(true);
        Map<String,Object> user=frontUserService.login(phone,pwd);
        if(user!=null){
            session.setAttribute("user",user);
            return 1;
        }
        return 0;
    }
    @RequestMapping("logout")
    public Integer logout(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return 1;
    }

}
