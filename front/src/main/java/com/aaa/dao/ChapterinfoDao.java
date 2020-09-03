package com.aaa.dao;

import com.aaa.entity.Chapterinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChapterinfoDao extends tk.mybatis.mapper.common.Mapper<Chapterinfo> {
    @Select("select c.ctid,c.title,c.artist,c.mp3,c.state,c.pid,p.poster,c.createdate  from chapterinfo c\n" +
            "left join programinfo p\n" +
            "on c.pid=p.pid where c.pid=#{pid}\n" +
            "order by createdate")
    List<Map<String,Object>> queryChapter(@Param("pid") Integer pid);
}
