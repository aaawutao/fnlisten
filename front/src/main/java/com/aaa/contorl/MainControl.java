package com.aaa.contorl;

import com.aaa.dao.PrograminfoDao;
import com.aaa.entity.Programinfo;
import com.aaa.service.ChapterinfoService;
import com.aaa.service.PrograminfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MainControl {
    @Resource
    PrograminfoService programinfoService;
    @Resource
    ChapterinfoService chapterinfoService;
    //主页
    @RequestMapping("/main")
    public String show(){
        return "main.html";
    }

    //详情
    @RequestMapping("/xianqing")
    public String xinqing(@RequestParam("anchortid") Integer anchortid,@RequestParam("pid") Integer pid,ModelMap modelMap){
        //节目
        modelMap.addAttribute("programinfo",programinfoService.query(pid,null,null,null).get(0));
        //主播节目
        modelMap.addAttribute("pros",programinfoService.query(null,null,anchortid,4));;
        //章节
        modelMap.addAttribute("chapterinfos",chapterinfoService.queryChapter(pid));
        return "xianqing.html";

    }
    //内容
    @RequestMapping("/context")
    public String context(){
        //种类查询
        //节目分类查询
        return "context.html";
    }
}
