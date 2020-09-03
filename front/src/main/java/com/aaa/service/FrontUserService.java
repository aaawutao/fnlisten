package com.aaa.service;

import com.aaa.dao.FrontuserDao;
import com.aaa.entity.FrontUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FrontUserService {

    @Resource
    FrontuserDao frontuserDao;
    //注册
    public int addFrontuser(FrontUser frontuser){
        return frontuserDao.insert(frontuser);
    }
}
