package com.aaa.service;

import com.aaa.dao.DepartmentinfoDao;
import com.aaa.entity.Departmentinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentinfoService {
    @Resource
    DepartmentinfoDao departmentinfoDao;
    //部门显示
    public List<Departmentinfo>DepartmentinfoAll(){
        return departmentinfoDao.DepartmentinfoAll();
    }
    //部门添加
    public int add(Departmentinfo departmentinfo){
        return departmentinfoDao.insert(departmentinfo);
    }
    //部门修改
    public int update(Departmentinfo departmentinfo){
        return departmentinfoDao.updateByPrimaryKey(departmentinfo);
    }
}
