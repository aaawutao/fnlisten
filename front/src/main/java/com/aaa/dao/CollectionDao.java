package com.aaa.dao;

import com.aaa.entity.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectionDao extends tk.mybatis.mapper.common.Mapper<Collection> {

    //删除
    @Delete("delete from collection where front_userid=#{userid} and pid=#{pid}")
    public Integer del(@Param("userid") Integer userid,@Param("pid") Integer pid);
}
