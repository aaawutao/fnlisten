package com.aaa.service;

import com.aaa.dao.TopupsetinfoDao;
import com.aaa.entity.Topupsetinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TopupsetinfoService {
    @Resource
    TopupsetinfoDao topupsetinfoDao;
    //充值设置
    public PageInfo<Topupsetinfo> TopupsetinfoAll(Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Topupsetinfo> userall = topupsetinfoDao.selectAll();
        PageInfo<Topupsetinfo> pageInfo = new PageInfo<>(userall);
        return pageInfo;
    }
    //添加
    public int add(Topupsetinfo topupsetinfo){
        return topupsetinfoDao.insert(topupsetinfo);
    }
    //修改
    public int update(Topupsetinfo topupsetinfo){
        return topupsetinfoDao.updateByPrimaryKey(topupsetinfo);
    }

    //查询消费记录
    public List<Map<String,Object>> selecttopset(){

        List<Map<String, Object>> selecttopset = topupsetinfoDao.selecttopset();
        return selecttopset;

    }
}
