package com.aaa.service;

import com.aaa.dao.RealnameinfoDao;
import com.aaa.entity.Realnameinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RealnameinfoService {

    @Resource
    RealnameinfoDao realnameinfoDao;

    public int addrealnameinfo(Realnameinfo realnameinfo) {
        return realnameinfoDao.insert(realnameinfo);
    }

    //修改用户的状态
    public int updatefrontflag(Integer front_userid) {
        return realnameinfoDao.updatefrontflag(front_userid);
    }

    //查询是否已经认证了
    public int queryByridcard(String ridcard){
        return realnameinfoDao.queryByridcard(ridcard);
    }


    public  Realnameinfo queryByfront_userid(Integer front_userid){
        return  realnameinfoDao.queryByfront_userid(front_userid);
    }
}
