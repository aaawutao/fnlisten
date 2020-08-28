package com.aaa.service;

import com.aaa.dao.PrograminfoDao;
import com.aaa.entity.Programinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PrograminfoService {
    @Resource
    PrograminfoDao programinfoDao;

    //分页查询节目
    public PageInfo<List<Map<String, Object>>> queryAll(Integer currentPage, Integer pageSize,Integer pid){
        PageHelper.startPage(currentPage,pageSize);
        List<Map<String, Object>> maps = programinfoDao.queryAll(pid);
        PageInfo<List<Map<String, Object>>> pageInfo = new PageInfo(maps);
        return pageInfo;
    }
}
