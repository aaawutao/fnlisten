package com.aaa.contorl;

import com.aaa.service.BuyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("add")
    @ResponseBody
    public Integer add(Integer userid,Integer pid,Integer ctid,Integer zhifumoney,Integer usermoney){
        return buyService.buyprogram(userid,pid,ctid,zhifumoney,usermoney);
    }




}
