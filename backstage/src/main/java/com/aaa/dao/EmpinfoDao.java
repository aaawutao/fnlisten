package com.aaa.dao;

import com.aaa.entity.Empinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface EmpinfoDao extends tk.mybatis.mapper.common.Mapper<Empinfo> {

    //查询没有分配账号的用户
    @Select("select * from empinfo where did=0 or did is null")
    List<Empinfo> queryByDid();




    @Select("select empid,empname,empbirth,empphone,empidentity,did,xueli,empentrydate,empdimissiondate from empinfo")
    List<Empinfo>findAll();

}
