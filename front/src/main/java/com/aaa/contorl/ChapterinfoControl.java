package com.aaa.contorl;

import com.aaa.service.ChapterinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("chapter")
public class ChapterinfoControl {
    @Resource
    ChapterinfoService chapterinfoService;

    @RequestMapping("querypid")
    @ResponseBody
    public List<Map<String,Object>> queryid(ModelMap map, @RequestParam("pid") Integer pid){
        return chapterinfoService.queryChapter(pid);
    }
    @RequestMapping("xiangqi")
    public String queryid(@RequestParam("pid") Integer pid){
        System.out.println("携带参数"+pid);
        return "xianqing.html";
    }


}
