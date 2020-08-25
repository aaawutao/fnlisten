package com.aaa.service;

import com.aaa.dao.TopupsetinfoDao;
import com.aaa.entity.Topupsetinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopupsetinfoService {
    @Resource
    TopupsetinfoDao topupsetinfoDao;
    //充值设置
    public List<Topupsetinfo> TopupsetinfoAll(){
        return topupsetinfoDao.TopupsetinfoAll();
    }
    //添加
    public int add(Topupsetinfo topupsetinfo){
        return topupsetinfoDao.insert(topupsetinfo);
    }
    //修改
    public int update(Topupsetinfo topupsetinfo){
        return topupsetinfoDao.updateByPrimaryKey(topupsetinfo);
    }
}
