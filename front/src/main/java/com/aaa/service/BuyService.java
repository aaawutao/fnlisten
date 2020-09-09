package com.aaa.service;

import com.aaa.dao.BuyDao;
import com.aaa.entity.Buy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BuyService {
    @Resource
    BuyDao buyDao;

    public boolean buycheck(Integer userid,Integer pid,Integer ctid){
        Buy qbbuy=buyDao.query(userid,pid,0);
        if(qbbuy!=null){
            return  true;
        }
        Buy zjbuy=buyDao.query(userid,pid,ctid);
        if(zjbuy!=null){
            return true;
        }
        return false;
    }
}
