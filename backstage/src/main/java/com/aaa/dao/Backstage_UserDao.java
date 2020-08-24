package com.aaa.dao;

import com.aaa.entity.Backstage_User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Backstage_UserDao extends Mapper<Backstage_User> {


    //查询用户的管理路径
    @Select("")
    List<Map<String,Object>> getUserUrls(Integer id);
}
