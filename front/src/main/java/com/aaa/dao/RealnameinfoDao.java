package com.aaa.dao;

import com.aaa.entity.Realnameinfo;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface RealnameinfoDao  extends Mapper<Realnameinfo> {


    @Update("update front_user  set front_userflag=2 where front_userid=#{front_userid}")
    int updatefrontflag(Integer front_userid);

}
