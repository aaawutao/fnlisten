package com.aaa.service;

import com.aaa.dao.FrontUserDao;
import com.aaa.entity.FrontUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FrontUserService {

    @Resource
    FrontUserDao frontUserDao;

    //查询用户信息
    public PageInfo<FrontUser> findAll(Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<FrontUser> userall = frontUserDao.selectAll();
        PageInfo<FrontUser> pageInfo = new PageInfo<>(userall);
        return pageInfo;
    }



}
