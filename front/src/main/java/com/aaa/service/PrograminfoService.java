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

    public List<Map<String, Object>> query(Integer pid, Integer ptid, Integer anchortid, Integer num) {
        return programinfoDao.query(pid, ptid, anchortid, num);
    }

    //添加
    public Integer add(Programinfo programinfo) {
        return programinfoDao.insert(programinfo);
    }
    //查询所有数据
    public  PageInfo<List<Map<String, Object>>> queryAll(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<Map<String, Object>> list = programinfoDao.queryAll();
        PageInfo<List<Map<String, Object>>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    //按类型查询
   public PageInfo<List<Map<String, Object>>> queryBytype(Integer page,Integer size,Integer pid, Integer ptid, Integer anchortid, Integer num) {

        PageHelper.startPage(page,size);
        List<Map<String, Object>> query = programinfoDao.query(pid, ptid, anchortid, num);
        PageInfo<List<Map<String, Object>>> pageInfo = new PageInfo(query);
        return pageInfo;
    }


}
