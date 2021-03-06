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

    //查询出个人信息
    public FrontUser queryByuserId(Integer front_userid){
        return  frontuserDao.queryByuserId(front_userid);
    }


    //获取虚拟币
    public Integer getxunibi(Integer front_userid){
        return frontuserDao.selectByPrimaryKey(front_userid).getFront_usermoney();
    }

    public Integer updateDate(Integer front_userid){
        return frontuserDao.updateDate(front_userid);
    }

    public int  updatefront_user( String front_username, String front_userpic,Integer front_userid){
        return  frontuserDao.updatefront_user(front_username,front_userpic,front_userid);
    }

    public  int  updatePassword( String front_userpwd,Integer front_userid){
        return frontuserDao.updatePassword(front_userpwd,front_userid);
    }

    //手机号唯一校验
    public int queryByphone(String front_userphone){
        return  frontuserDao.queryByphone(front_userphone);
    }
}
