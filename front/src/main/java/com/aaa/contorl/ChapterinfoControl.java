package com.aaa.contorl;

import com.aaa.service.ChapterinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("chapter")
public class ChapterinfoControl {
    @Resource
    ChapterinfoService chapterinfoService;

    @RequestMapping("querypid")
    public String queryid(ModelMap map,@RequestParam("pid") Integer pid){
        map.addAttribute("chapters",chapterinfoService.queryChapter(pid));
        return "play.html";
    }


}
