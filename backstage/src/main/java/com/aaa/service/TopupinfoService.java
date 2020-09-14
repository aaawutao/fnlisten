package com.aaa.service;

import com.aaa.dao.TopupinfoDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TopupinfoService {

    @Resource
    TopupinfoDao topupinfoDao;
    //查询所有的用户充值记录
    public  PageInfo<Map<String, Object>>  querytopupi(Integer currentPage,Integer pageSize,String front_userphone){
        PageHelper.startPage(currentPage,pageSize);
        List<Map<String, Object>> querytopupi = topupinfoDao.querytopupi(front_userphone);
        System.out.println("模糊查询："+querytopupi);
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(querytopupi);
        return mapPageInfo;
    }
}
