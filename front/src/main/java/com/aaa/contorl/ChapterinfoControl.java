package com.aaa.contorl;

import com.aaa.entity.Chapterinfo;
import com.aaa.service.ChapterinfoService;
import com.aaa.util.FileRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("chapter")
public class ChapterinfoControl {
    //上传路径
    @Value("${prop.filepath}")
    String staticurl;

    @Resource
    ChapterinfoService chapterinfoService;
    FileRule fileRule=new FileRule();
    //获取章节
    @RequestMapping("querypid")
    @ResponseBody
    public List<Map<String,Object>> queryid(ModelMap map, @RequestParam("pid") Integer pid){
        return chapterinfoService.queryChapter(pid);
    }

    @RequestMapping("add")
    @ResponseBody
    public Integer add(Chapterinfo chapterinfo,@RequestParam("yingping") MultipartFile yingping,@RequestParam("front_userphone") String phone ,@RequestParam("flag") String flag) throws IOException {
        String url=fileRule.fileupload(staticurl,yingping,phone,flag);
        chapterinfo.setSrc(url);
        chapterinfo.setCreatedate(new Date());
        return chapterinfoService.add(chapterinfo);
    }


}
