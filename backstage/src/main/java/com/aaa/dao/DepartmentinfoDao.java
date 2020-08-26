package com.aaa.dao;

import com.aaa.entity.Departmentinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DepartmentinfoDao extends Mapper<Departmentinfo> {

    //查询部门
    @Select("select did,dname from departmentinfo")
    List<Departmentinfo> DepartmentinfoAll();
//
//    //添加
//    @Insert("insert into departmentinfo (dname) values (#{did},#{dname})")
//    int add(Departmentinfo departmentinfo);
//
//    //修改
//    @Update("update departmentinfo set dname=#{dname} where did=#{did}")
//    int update(Departmentinfo departmentinfo);
}
