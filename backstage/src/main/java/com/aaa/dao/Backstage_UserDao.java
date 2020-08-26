package com.aaa.dao;

import com.aaa.entity.Backstage_User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Backstage_UserDao extends Mapper<Backstage_User> {

    @Update("update backstage_user set isenable=#{isenable} where backstage_userid=#{backstage_userid}")
    int updateFlag(@Param("isenable") Integer isenable,@Param("backstage_userid") Integer backstage_userid);
}
