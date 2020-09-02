package com.aaa.contorl;

import com.aaa.util.AddSmsSign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@RequestMapping("userlogin")
public class UserloginController {

    @RequestMapping("phoneCheck")
    public Map<String,Object> phoneCheck(String phone){
        Map<String, Object> map = AddSmsSign.contextLoads(phone);
        System.out.println(map);
        return map;
    }
}
