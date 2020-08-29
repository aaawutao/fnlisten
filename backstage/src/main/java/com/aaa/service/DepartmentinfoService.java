package com.aaa.service;

import com.aaa.dao.DepartmentinfoDao;
import com.aaa.entity.Departmentinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentinfoService {
    @Resource
    DepartmentinfoDao departmentinfoDao;
    //分页查询数据
    public PageInfo<Departmentinfo> findAll(Integer currentPage, Integer pageSize){
            PageHelper.startPage(currentPage,pageSize);
            List<Departmentinfo> type = departmentinfoDao.selectAll();
            PageInfo<Departmentinfo> pageInfo = new PageInfo<>(type);
            return pageInfo;
    }

    public List<Departmentinfo> depfindAll(){
        return  departmentinfoDao.selectAll();
    }

    //添加类型
    public int addprotype(Departmentinfo departmentinfo){
        return  departmentinfoDao.insert(departmentinfo);
    }

    //删除类型
    public int deleteprotype(Integer did){
        return  departmentinfoDao.deleteByPrimaryKey(did);
    }

    //修改类型
    public int updateprotype(Departmentinfo departmentinfo){
        return  departmentinfoDao.updateByPrimaryKey(departmentinfo);
    }
}
