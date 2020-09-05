package com.aaa.contorl;

import com.aaa.entity.Programinfo;
import com.aaa.service.PrograminfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("programinfo")
public class PrograminfoControl {
    @Resource
    PrograminfoService programinfoService;

    @RequestMapping("add")
    @ResponseBody
    public Integer add(Programinfo programinfo){
        return programinfoService.add(programinfo);
    }


}
