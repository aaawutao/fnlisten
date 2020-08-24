package com.aaa.service;

import com.aaa.dao.Backstage_UserDao;
import com.aaa.entity.Backstage_User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Backstage_UserService  {
    @Resource
    Backstage_UserDao backstage_userDao;

    /**
     * 校验用户名
     *
     */
    public Backstage_User checkUserName(String name){
         Backstage_User user=new Backstage_User();
         user.setBackstage_uname(name);
        return backstage_userDao.selectOne(user);
    }






}
