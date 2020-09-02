package com.aaa.controller;


import com.aaa.entity.Programinfo;
import com.aaa.service.Backstage_UserService;
import com.aaa.service.PrograminfoService;
import com.aaa.service.ProgramtypeService;
import com.aaa.util.FileRule;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("programinfo")
public class PrograminfoController {

    @Resource
    PrograminfoService programinfoService;

    @RequestMapping("programinfoAll")
    public PageInfo<List<Map<String, Object>>> findAll(Integer currentPage, Integer pageSize,Integer pid,Integer bfid){
        return programinfoService.queryAll(currentPage,pageSize,pid,bfid);
    }

    //修改状态是否展示
    @RequestMapping("updateppstatus")
    public int updateppstatus(Integer pstatus,Integer pid){
        return programinfoService.updateppstatus(pstatus,pid);
    }


    //上传路径
    @Value("${prop.filepath}")
    String staticurl;



    FileRule fileRule=new FileRule();
    //添加节目数据
    @RequestMapping("insertprograminfo")
    public int insertprograminfo(@RequestParam("file") MultipartFile file,String pname,Integer acid,String psource,
                                 Integer chapterorder,Integer ptid,Integer pstate,Double allprice,String pintroduction,
                                 Integer flag,String backstage_uname){

        String photourl="";
      try{
           String flag1=flag.toString();
           photourl=fileRule.fileupload(staticurl,file,backstage_uname,flag1);
      }catch (Exception error){
          error.printStackTrace();
      }
          Programinfo programinfo=new Programinfo();
          programinfo.setPname(pname);
          programinfo.setPoster(photourl);
          programinfo.setPintroduction(pintroduction);
          programinfo.setPtid(ptid);
          programinfo.setPsource(psource);
          programinfo.setAnchortid(acid);
          programinfo.setChapterorder(chapterorder);
          programinfo.setPcreatedate(new Date());
          programinfo.setBuycount(0);
          programinfo.setPstate(pstate);
          programinfo.setAllprice(allprice);
          programinfo.setPstatus(0);
        return programinfoService.insertprograminfo(programinfo);
    }
}
