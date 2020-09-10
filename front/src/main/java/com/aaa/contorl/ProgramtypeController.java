package com.aaa.contorl;

import com.aaa.service.PrograminfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("programtype")
public class ProgramtypeController {


    @Resource
    PrograminfoService programinfoService;


    @ResponseBody
   @RequestMapping("queryBytype")
    public  PageInfo<List<Map<String, Object>>> queryBytype(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue ="8") Integer size,
                         Integer ptid) {
                PageInfo<List<Map<String, Object>>> listPageInfo = programinfoService.queryBytype(page, size,null,ptid,null,null);
                System.out.println(listPageInfo);
        return listPageInfo;
    }

}
