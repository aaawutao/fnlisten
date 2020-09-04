package com.aaa.controller;

import com.aaa.entity.Empinfo;
import com.aaa.service.EmpinfoService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("empinfo")
public class EmpinfoController {
    @Resource
    EmpinfoService empinfoService;

        @RequestMapping("findAll")
        public String findAll (Model model){
            PageInfo<Empinfo> list = empinfoService.findAll();
            model.addAttribute("list", list.getList());
            return "empinfo";
        }

        @RequestMapping("listAll")
        public List<Empinfo> listAll () {
            List<Empinfo> list = empinfoService.listAll();
            return list;
        }

        @RequestMapping("save")
        public int save (Empinfo empinfo){
            System.out.println("save:" + empinfo);
            //获取当前时间
           empinfo.setEmpentrydate(new Date());
            return empinfoService.save(empinfo);

        }
//    @RequestMapping("update")
//    public int update (Empinfo empinfo){
//        System.out.println("card:" + empinfo.getEmpidentity());
//        return empinfoService.update(empinfo);
//    }

        //查询没有分配账号的用户
        @RequestMapping("queryByDid")
        public List<Empinfo> queryByDid () {
            return empinfoService.queryByDid();
        }
    }
