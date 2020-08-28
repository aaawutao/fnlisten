package com.aaa.controller;

import com.aaa.entity.Chapterinfo;
import com.aaa.service.ChapterinfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("chapterinfo")
public class ChapterinfoController {

    @Resource
    ChapterinfoService chapterinfoService;

    @RequestMapping("chapterinfoQuery")
    public PageInfo<Chapterinfo> findAll(Integer currentPage, Integer pageSize,Integer pid){
        System.out.println();
        return chapterinfoService.findAll(currentPage,pageSize,pid);
    }
}
