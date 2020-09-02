package com.aaa.controller;

import com.aaa.entity.Anchorinfo;
import com.aaa.service.AnchorinfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("anchorinfo")
public class AnchorinfoController {

    @Resource
    AnchorinfoService anchorinfoService;

    @RequestMapping("queryAllByacid")
    public List<Anchorinfo> queryAllByacid(Integer bfid){
        return  anchorinfoService.queryAllByacid(bfid);
    }
}
