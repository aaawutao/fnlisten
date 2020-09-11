package com.aaa.contorl;

import com.aaa.entity.FrontUser;
import com.aaa.service.AnchorinfoService;
import com.aaa.service.FrontUserService;
import com.aaa.util.FileRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("frontuser")
public class FrontUserControl {

    //上传路径
    @Value("${prop.filepath}")
    String staticurl;
    FileRule fileRule = new FileRule();
    @Resource
    FrontUserService frontUserService;

    @Resource
    AnchorinfoService anchorinfoService;

    @RequestMapping("getxunibi")
    @ResponseBody
    public Integer getxunibi(Integer front_userid){
        return frontUserService.getxunibi(front_userid);
    }


    @RequestMapping("updatefrontuser")
    @ResponseBody
    public int  updatefront_user(@RequestParam("front_userpic") MultipartFile front_userpic,
                                 String front_username, Integer front_userid,String phone,String flag,Integer front_userflag,String front_photosrc){
        String fileupload="";
        try {
            if(front_userpic.getOriginalFilename().equals("") || front_userpic.getOriginalFilename()==null){
                fileupload=front_photosrc;
            }else{
                fileupload = fileRule.fileupload(staticurl, front_userpic, phone, flag);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(front_userflag==2){
            int updatepetname = anchorinfoService.updatepetname(front_username, front_userid);
        }
       /* int queryBybfid = anchorinfoService.queryBybfid(front_userid);
        if(queryBybfid==0){
            int addanchor = anchorinfoService.addanchor(front_userid, front_username);
        }else {
            int updatepetname = anchorinfoService.updatepetname(front_username, front_userid);
        }*/
        int updatefront_user = frontUserService.updatefront_user(front_username, fileupload, front_userid);
        return 1;

    }

    @RequestMapping("updatepassword")
    @ResponseBody
    public  int  updatePassword( String front_userpwd,Integer front_userid){
        return frontUserService.updatePassword(front_userpwd,front_userid);
    }

    //手机号唯一校验
    @RequestMapping("queryByphone")
    @ResponseBody
    public int queryByphone(String front_userphone){
        System.out.println(front_userphone);
        System.out.println(frontUserService.queryByphone(front_userphone));
        return  frontUserService.queryByphone(front_userphone);
    }
}
