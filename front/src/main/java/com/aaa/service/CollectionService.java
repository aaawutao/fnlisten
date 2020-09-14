package com.aaa.service;

import com.aaa.dao.CollectionDao;
import com.aaa.entity.Collection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectionService {
    @Resource
    CollectionDao collectionDao;

    public Integer add(Collection collection){
        return collectionDao.insert(collection);
    }
    public Integer del(Integer userid,Integer pid){
        return  collectionDao.del(userid,pid);
    }

}
