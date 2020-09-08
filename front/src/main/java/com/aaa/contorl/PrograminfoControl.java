package com.aaa.contorl;

import com.aaa.entity.Programinfo;
import com.aaa.service.PrograminfoService;
import com.aaa.util.FileRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("programinfo")
public class PrograminfoControl {
    //上传路径
    @Value("${prop.filepath}")
    String staticurl;
    FileRule fileRule = new FileRule();
    @Resource
    PrograminfoService programinfoService;

    @RequestMapping("add")
    @ResponseBody
    public Integer add(Programinfo programinfo, @RequestParam("photo") MultipartFile photo, @RequestParam("front_userphone") String phone, @RequestParam("flag") String flag) throws IOException {
        //programinfoService.add(programinfo)
        String url = fileRule.fileupload(staticurl, photo, phone, flag);
        programinfo.setPoster(url);
        programinfo.setChapterorder(1);
        programinfo.setPcreatedate(new Date());
        programinfo.setBuycount(0);
        programinfo.setPstate(0);
        programinfo.setAllprice(0D);
        programinfo.setPstatus(0);
        return programinfoService.add(programinfo);
    }


}
