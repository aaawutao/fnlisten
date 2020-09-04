package com.aaa.dao;

import com.aaa.entity.Empinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpinfoDao extends tk.mybatis.mapper.common.Mapper<Empinfo> {

    //查询没有分配账号的用户
    @Select("select * from empinfo where did=0 or did is null")
    List<Empinfo> queryByDid();

    @Select("select empid,empname,empphone,empidentity,did,xueli,empentrydate,empdimissiondate from empinfo")
    List<Empinfo>findAll();

    @Select("select * from backstage_user bu\n" +
            " left join  empinfo ei \n" +
            " on bu.empid=ei.empid\n" +
            " left join anchorinfo ai\n" +
            " on bu.backstage_userid=ai.bfid\n" +
            " where ei.empid=#{empid}")
    Map<String,Object> queryByempid(@Param("empid") Integer empid);


    @Update("update empinfo set empphone=#{empphone} where empid=#{empid}")
    int updatephone(@Param("empphone") String empphone,@Param("empid") Integer empid);
}
