package com.aaa.dao;

import com.aaa.entity.Buy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuyDao extends tk.mybatis.mapper.common.Mapper<Buy> {
    @Select("select bpid,purchaser,pid,ctid,purchaservc,\n" +
            "purchasermoney,acquiree_original_money\n" +
            "acquireeparticipation,acquiree_now_money,buydate from buy where purchaser=#{purchaser} and pid=#{pid} and ctid=#{ctid}")
    Buy query(@Param("purchaser") Integer purchaser ,@Param("pid") Integer pid,@Param("ctid") Integer ctid );


    @Select("select \n" +
            "(select pname from programinfo p where p.pid=b.pid) as pname,\n" +
            "if(b.ctid=0,'全本',(select title   from chapterinfo t where t.ctid=b.ctid)) as title,\n" +
            "purchaservc,buydate\n" +
            "from buy b where b.purchaser=#{userid}")
    List<Map<String,Object>> show(@Param("userid") Integer userid);
}
