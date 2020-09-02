package com.aaa.service;

import com.aaa.dao.ProgramtypeinfoDao;
import com.aaa.entity.Programtypeinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProgramtypeService {

    @Resource
    ProgramtypeinfoDao programtypeinfoDao;
    //分页查询数据
    public PageInfo<Programtypeinfo> findAll(Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Programtypeinfo> type = programtypeinfoDao.selectAll();
        PageInfo<Programtypeinfo> pageInfo = new PageInfo<>(type);
        return pageInfo;
    }
    //查询出所有节目类型
    public List<Programtypeinfo> queryAllProtype(){
        return programtypeinfoDao.selectAll();
    }

    //添加类型
    public int addprotype(Programtypeinfo programtypeinfo){
        return  programtypeinfoDao.insert(programtypeinfo);
    }

    //删除类型
    public int deleteprotype(Integer ptid){
        return  programtypeinfoDao.deleteByPrimaryKey(ptid);
    }

    //修改类型
    public int updateprotype(Programtypeinfo programtypeinfo){
        return  programtypeinfoDao.updateByPrimaryKey(programtypeinfo);
    }
}
