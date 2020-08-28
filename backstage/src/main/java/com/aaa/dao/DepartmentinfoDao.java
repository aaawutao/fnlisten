package com.aaa.dao;

import com.aaa.entity.Departmentinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 部门类型
 */
@org.apache.ibatis.annotations.Mapper
public interface DepartmentinfoDao extends Mapper<Departmentinfo> {

    //查询部门
    @Select("select did,dname from departmentinfo")
    List<Departmentinfo> DepartmentinfoAll();

}
