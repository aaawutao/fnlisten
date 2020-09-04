package com.aaa.controller;

import com.aaa.entity.Anchorinfo;
import com.aaa.entity.Backstage_User;
import com.aaa.service.AnchorinfoService;
import com.aaa.service.Backstage_UserService;
import com.aaa.util.FileRule;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class Backstage_userController {
    //上传路径
    @Value("${prop.filepath}")
    String staticurl;
    @Resource
    Backstage_UserService backstage_userService;
    @Resource
    AnchorinfoService anchorinfoService;
    FileRule fileRule=new FileRule();
    /*//修改密码
    @RequestMapping("upwd")
    public int upwd(@RequestParam("map") Map<Object,Object> map){
        int userid = (int) map.get("id");
        String upwd = (String) map.get("pwd");
        return backstage_userService.updatepwd(upwd, userid);
    }*/
    @RequestMapping("upload")
    public Integer  upload(@RequestParam("file") MultipartFile file,@RequestParam("userid") Integer userid,@RequestParam("username") String username,@RequestParam("flag") String flag){
        try{
            String photourl=fileRule.fileupload(staticurl,file,username,flag);
            System.out.println(photourl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    //分页查询
    @RequestMapping("findAll")
    public  PageInfo<Backstage_User> findAll(Integer currentPage,Integer pageSize){
        return backstage_userService.findAll(currentPage,pageSize);
    }

    @RequestMapping("updateFlag")
    public int updateFlag(Integer isenable,Integer backstage_userid){
        return backstage_userService.updateFlag(isenable,backstage_userid);
    }

    @RequestMapping("addassignment")
    public int addassignment(String backstage_uname,String backstage_upwd,Integer did,Integer empid,Integer actype){
        try{
            Backstage_User backstage_user = new Backstage_User();
            backstage_user.setBackstage_uname(backstage_uname);
            backstage_user.setBackstage_upwd(backstage_upwd);
            backstage_user.setEmpid(empid);
            backstage_userService.insertBackstageUser(backstage_user);
            backstage_userService.insertdept(did,empid);
            if(actype==0){
                //生成主键编号
                Integer dfid=backstage_user.getBackstage_userid();
                Anchorinfo anchorinfo = new Anchorinfo();
                anchorinfo.setActype(actype);
                anchorinfo.setBfid(dfid);
                anchorinfoService.addAnchorinfo(anchorinfo);
            }
            return 1;
        }catch (Exception err){
            return 0;
        }
    }


    //查询出账号下的用户详细信息
    @RequestMapping("queryByUserdetails")
    public List<Map<String,Object>> queryByUserdetails(Integer backstage_userid){
        return backstage_userService.queryBydetails(backstage_userid);
    }

    @RequestMapping("queryBz")
    public Anchorinfo queryBz(Integer bfid){
        return backstage_userService.queryByZb(bfid);
    }

    //修改图片路径
    @RequestMapping("updatephoto")
    public int  updatephoto(@RequestParam("file") MultipartFile file,Integer backstage_userid,Integer flag,String backstage_uname){

        String flag1 = flag.toString();
        String photourl="";
        try{
            photourl=fileRule.fileupload(staticurl,file,backstage_uname,flag1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  backstage_userService.updatephoto(photourl,backstage_userid);
    }
    //修改密码
    @RequestMapping("updatepwd")
    public int updatepwd(String backstage_upwd,Integer backstage_userid){

        return backstage_userService.updatepwd(backstage_upwd,backstage_userid);
    }

}
