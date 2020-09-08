package com.aaa.service;

import com.aaa.dao.FrontuserDao;
import com.aaa.entity.FrontUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class FrontUserService {

    @Resource
    FrontuserDao frontuserDao;

    //注册
    public int addFrontuser(FrontUser frontuser) {
        return frontuserDao.insert(frontuser);
    }

    //登录
    public Map<String, Object> login(String phone, String pwd) {
        return frontuserDao.login(phone, pwd);
    }

    //获取虚拟币
    public Integer getxunibi(Integer front_userid){
        return frontuserDao.selectByPrimaryKey(front_userid).getFront_usermoney();
    }
}
