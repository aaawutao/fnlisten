package com.aaa.dao;

import com.aaa.entity.FrontUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface FrontuserDao  extends Mapper<FrontUser> {

/*
    @Insert("insert into front_user (front_userphone,front_userpwd) \n" +
            "values " +
            "(#{phone},#{front_userpwd},")
    int addFrontuser(@Param("phone") String phone,@Param("front_userpwd") String front_userpwd);*/
    @Select("select fu.front_userid,fu.front_username,fu.front_userpic,fu.front_userphone,fu.front_userpwd,\n" +
            "fu.front_userstate,fu.front_usercreatedate,fu.front_uservipoutdata,fu.front_userflag,\n" +
            "fu.flag,fu.front_userqqflag,fu.front_usermoney,a.acid,a.actype,a.bfid,a.petname from front_user fu\n" +
            "left join anchorinfo a\n" +
            "on a.actype=1 and a.bfid=fu.front_userid where fu.front_userphone=#{phone} and fu.front_userpwd=#{pwd} ")
    Map<String,Object> login(@Param("phone") String phone,@Param("pwd") String pwd);

}
