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
    public PageInfo<List<Map<String, Object>>> queryAll(Integer currentPage, Integer pageSize, Integer bfid){
        PageHelper.startPage(currentPage,pageSize);
        List<Map<String, Object>> maps = programinfoDao.queryAll(bfid);
        PageInfo<List<Map<String, Object>>> pageInfo = new PageInfo(maps);
        return pageInfo;
    }

    //修改状态是否展示
    public int updateppstatus(Integer pstatus,Integer pid){
        return programinfoDao.updateppstatus(pstatus,pid);
    }

    //添加数据
    public int insertprograminfo(Programinfo programinfo){
        return programinfoDao.insert(programinfo);
    }

    //查询详细信息
    public List<Map<String,Object>> querybypid( Integer pid){
        return  programinfoDao.querybypid(pid);
    }

}
