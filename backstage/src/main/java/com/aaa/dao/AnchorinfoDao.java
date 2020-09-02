package com.aaa.dao;

import com.aaa.entity.Anchorinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
public interface AnchorinfoDao extends Mapper<Anchorinfo> {

    @Select("select * from anchorinfo where bfid=#{bfid} and actype=0;")
    List<Anchorinfo>  queryAllByacid(@Param("bfid") Integer bfid);

}
