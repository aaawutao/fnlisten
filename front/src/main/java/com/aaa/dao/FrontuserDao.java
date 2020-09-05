package com.aaa.dao;

import com.aaa.entity.FrontUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface FrontuserDao  extends Mapper<FrontUser> {

/*
    @Insert("insert into front_user (front_userphone,front_userpwd) \n" +
            "values " +
            "(#{phone},#{front_userpwd},")
    int addFrontuser(@Param("phone") String phone,@Param("front_userpwd") String front_userpwd);*/


}
