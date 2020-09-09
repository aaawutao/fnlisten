package com.aaa.contorl;

import com.aaa.service.BuyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("buy")
public class BuyControl {

    @Resource
    BuyService buyService;

    @RequestMapping("check")
    @ResponseBody
    public boolean check(Integer userid,Integer pid,Integer ctid){
        return buyService.buycheck(userid,pid,ctid);
    }


}
