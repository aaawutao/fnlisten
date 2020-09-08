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

    public List<Topupsetinfo> query(Integer tstype) {
        Topupsetinfo topupsetinfo = new Topupsetinfo();
        topupsetinfo.setTstype(tstype);
        return topupsetinfoDao.select(topupsetinfo);
    }

}
