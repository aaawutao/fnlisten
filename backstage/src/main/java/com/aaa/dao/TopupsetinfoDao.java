package com.aaa.dao;

import com.aaa.entity.Topupsetinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TopupsetinfoDao extends tk.mybatis.mapper.common.Mapper<Topupsetinfo> {
    @Select("select tsid,tstype,tscustom,tsmoney from topupsetinfo")
    List<Topupsetinfo>TopupsetinfoAll();
    @Insert("insert into topupsetinfo (tstype,tscustom,tsmoney) values (#{tstype},#{tscustom},#{tsmoney})")
    int add(Topupsetinfo topupsetinfo);
    @Update("update topupsetinfo set tstype=#{tstype},tscustom=#{tscustom},tsmoney=#{tsmoney} where tsid=#{tsid}")
    int update(Topupsetinfo topupsetinfo);
}
