package com.aaa.controller;

import com.aaa.entity.Chapterinfo;
import com.aaa.service.ChapterinfoService;
import com.aaa.util.FileRule;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("chapterinfo")
public class ChapterinfoController {

    @Resource
    ChapterinfoService chapterinfoService;
    //上传路径
    @Value("${prop.filepath}")
    String staticurl;
    FileRule fileRule=new FileRule();


    @RequestMapping("chapterinfoQuery")
    public List<Chapterinfo> querychapBypid(Integer pid){
        return  chapterinfoService.querychapBypid(pid);
    }

    @RequestMapping("addchapter")
    public int addchapter(@RequestParam("file") MultipartFile file ,String title,
                          String artist,Integer state,Integer virtualcurrency,Integer pid,Integer flag,String backstage_uname){
        String audiofile="";
        try{
            String flag1=flag.toString();
            audiofile=fileRule.fileupload(staticurl,file,backstage_uname,flag1);
        }catch (Exception error){
            error.printStackTrace();
        }
        Chapterinfo chapterinfo = new Chapterinfo();
        chapterinfo.setTitle(title);
        chapterinfo.setArtist(artist);
        chapterinfo.setMp3(audiofile);
        chapterinfo.setState(state);
        chapterinfo.setVirtualcurrency(virtualcurrency);
        chapterinfo.setPid(pid);
        chapterinfo.setCreatedate(new Date());
        return  chapterinfoService.addchapter(chapterinfo);
    }
}
