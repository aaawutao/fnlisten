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
    //员工显示
    public PageInfo<Empinfo> EmpinfoAll(Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Empinfo> userall = empinfoDao.selectAll();
        PageInfo<Empinfo> pageInfo = new PageInfo<>(userall);
        return pageInfo;
    }
    //员工添加
    public int add(Empinfo empinfo){
        return empinfoDao.insert(empinfo);
    }
    //员工修改
    public  int update(Empinfo empinfo){
        return empinfoDao.updateByPrimaryKey(empinfo);
    }
}
