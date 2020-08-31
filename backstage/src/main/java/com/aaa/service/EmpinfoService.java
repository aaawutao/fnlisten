package com.aaa.service;

import com.aaa.dao.EmpinfoDao;
import com.aaa.entity.Empinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

@Service
public class EmpinfoService {
    @Resource
    EmpinfoDao empinfoDao;
    public List<Empinfo> EmpinfoAll() {
        return empinfoDao.findAll();
    }

    public PageInfo<Empinfo> findAll() {
        PageHelper.startPage(1, 5);
        List<Empinfo> list = empinfoDao.findAll();
        PageInfo<Empinfo> pageInfo = new PageInfo<Empinfo>(list);
        return pageInfo;
    }

    public List<Empinfo> listAll() {
        return empinfoDao.findAll();
    }

    public int save(Empinfo empinfo) {
        return empinfoDao.insertSelective(empinfo);
    }

    public int update(Empinfo empinfo) {
        return empinfoDao.updateByPrimaryKey(empinfo);
    }


    //查询没有分配账号的用户
    public List<Empinfo> queryByDid(){
        return empinfoDao.queryByDid();
    }



}
