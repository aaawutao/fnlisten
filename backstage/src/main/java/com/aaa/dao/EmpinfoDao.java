package com.aaa.dao;

import com.aaa.entity.Empinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface EmpinfoDao extends tk.mybatis.mapper.common.Mapper<Empinfo> {
    @Select("select * from empinfo")
    List<Empinfo>EmpinfoAll();
}
