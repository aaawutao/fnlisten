package com.aaa.dao;

import com.aaa.entity.Backstage_User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Backstage_UserDao extends Mapper<Backstage_User> {

    //查询所有员工
    List<Backstage_User> findAll();

    //校验用户名密码
    @Select("select * from Backstage_User where backstage_uname='#{backstage_uname}'  and backstage_upwd='#{backstage_upwd}'")
    boolean findCheckUserPwd(String backstage_uname,String backstage_upwd);

}
