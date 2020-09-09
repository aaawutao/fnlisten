package com.aaa.dao;

import com.aaa.entity.Buy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BuyDao extends tk.mybatis.mapper.common.Mapper<Buy> {
    @Select("select bpid,purchaser,pid,ctid,purchaservc,\n" +
            "purchasermoney,acquiree_original_money\n" +
            "acquireeparticipation,acquiree_now_money,buydate from buy where purchaser=#{purchaser} and pid=#{pid} and ctid=#{ctid}")
    Buy query(@Param("purchaser") Integer purchaser ,@Param("pid") Integer pid,@Param("ctid") Integer ctid );

}
