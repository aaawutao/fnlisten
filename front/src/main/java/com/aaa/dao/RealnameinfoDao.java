package com.aaa.dao;

import com.aaa.entity.Realnameinfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface RealnameinfoDao extends Mapper<Realnameinfo> {


    @Update("update front_user  set front_userflag=2 where front_userid=#{front_userid}")
    int updatefrontflag(Integer front_userid);

    //查询是否已经认证了
    @Select("select count(rid) from realnameinfo where ridcard=#{ridcard}")
    int queryByridcard(String ridcard);

    @Select("select rid,rtype,rname,ridcard from realnameinfo where front_userid=#{front_userid}")
    Realnameinfo queryByfront_userid(Integer front_userid);
}
