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

    public List<Backstage_User> findAll(){
        return backstage_userDao.selectAll();
    }

    public boolean findCheck(String backstage_uname,String backstage_upwd){
        return  backstage_userDao.findCheckUserPwd(backstage_uname,backstage_upwd);
    }
}
