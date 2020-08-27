package com.aaa.dao;

import com.aaa.entity.Backstage_User;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Backstage_UserDao extends Mapper<Backstage_User> {

    @Update("update backstage_user set isenable=#{isenable} where backstage_userid=#{backstage_userid}")
    int updateFlag(@Param("isenable") Integer isenable,@Param("backstage_userid") Integer backstage_userid);

    //添加账号到给用户
    @Insert("insert into backstage_user (backstage_uname,backstage_upwd,empid) values (#{backstage_uname},#{backstage_upwd},#{empid})")
    @Options(useGeneratedKeys = true, keyProperty = "backstage_userid")//添加成功是获取自增的主键编号
    //int insertBackstageUser(@Param("backstage_uname") String backstage_uname,@Param("backstage_upwd") String backstage_upwd,@Param("empid") Integer empid);
    int insertBackstageUser(Backstage_User backstage_user);

    //员工部门添加部门
    @Update("update  empinfo set did=#{did} where empid=#{empid}")
    int insertdept(@Param("did") Integer did,@Param("empid") Integer empid);

    //添加区分员工和主播
    /*@Insert("insert into anchorinfo (actype,dfid) values (#{actype},#{dfid})")
    int addanchorinfo(@Param("actype") Integer actype,@Param("dfid") Integer dfid);*/
}
