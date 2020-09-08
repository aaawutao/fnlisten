package com.aaa.contorl;

import com.aaa.entity.Realnameinfo;
import com.aaa.service.RealnameinfoService;
import com.aaa.util.FileRule;
import com.aaa.util.PersonalApprove;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("realnameinfo")
public class RealnameinfoController {

    //上传路径
    @Value("${prop.filepath}")
    String staticurl;
    FileRule fileRule = new FileRule();
    @Resource
    RealnameinfoService realnameinfoService;


    //身份证认证
    @RequestMapping("addrealnameinfo")
    @ResponseBody
    public int addrealnameinfo(@RequestParam("ridcardpositivepic") MultipartFile ridcardpositivepic
            , @RequestParam("rname") String rname, @RequestParam("ridcard") String ridcard,
                               @RequestParam("front_userphone") String front_userphone, @RequestParam("flag") String flag,
                               @RequestParam("front_userid") String front_userid) {
        String imgageurl = "";
        try {
            imgageurl = fileRule.fileupload(staticurl, ridcardpositivepic, front_userphone, flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(imgageurl);
        //把图片路径改为base64
        String toBase64 = PersonalApprove.NetImageToBase64(imgageurl);
        JSONObject approve = PersonalApprove.Approve(toBase64);
        //根据code值判断是否认证成功
        Integer code = (Integer) approve.get("code");
        if (code == 200) {
            JSONObject data = (JSONObject) approve.get("data");
            String idcard = data.get("idcard").toString();
            String name = data.get("name").toString();
            if (idcard.equals(ridcard) && name.equals(rname)) {
                Realnameinfo realnameinfo = new Realnameinfo();
                realnameinfo.setRidcard(idcard);
                realnameinfo.setRname(name);
                realnameinfo.setCertifiesdate(new Date());
                realnameinfo.setRidcardpositivepic(imgageurl);
                realnameinfo.setRtype("二代身份证");
                Integer userid= Integer.valueOf(front_userid);
                realnameinfo.setFront_userid(userid);
                System.out.println("添加实体类："+realnameinfo);
                int addrealnameinfo = realnameinfoService.addrealnameinfo(realnameinfo);
                return addrealnameinfo;
            }
        }
        return 0;

    }
    @ResponseBody
    @RequestMapping("updatefrontflag")
    public int updatefrontflag( Integer front_userid){
        System.out.println(front_userid);
        return  realnameinfoService.updatefrontflag(front_userid);
    }





}
