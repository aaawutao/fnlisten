package com.aaa.dao;

import com.aaa.entity.Chapterinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ChapterinfoDao extends Mapper<Chapterinfo> {

    @Select("select * from chapterinfo where pid=#{pid} \n" +
            "group by createdate desc")
    List<Chapterinfo> queryAll(@Param("pid") Integer pid);
}
