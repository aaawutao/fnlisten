package com.aaa.service;

import com.aaa.dao.EmpinfoDao;
import com.aaa.entity.Empinfo;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

@Service
public class EmpinfoService {
    @Resource
    EmpinfoDao empinfoDao;
    //员工显示
    public List<Empinfo>EmpinfoAll(){
        return empinfoDao.EmpinfoAll();
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
