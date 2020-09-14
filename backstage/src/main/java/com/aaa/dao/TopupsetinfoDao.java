package com.aaa.dao;

import com.aaa.entity.Topupsetinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TopupsetinfoDao extends tk.mybatis.mapper.common.Mapper<Topupsetinfo> {
    @Select("select tsid,tstype,tscustom,tsmoney from topupsetinfo")
    List<Topupsetinfo>TopupsetinfoAll();
    @Insert("insert into topupsetinfo (tstype,tscustom,tsmoney) values (#{tstype},#{tscustom},#{tsmoney})")
    int add(Topupsetinfo topupsetinfo);
    @Update("update topupsetinfo set tstype=#{tstype},tscustom=#{tscustom},tsmoney=#{tsmoney} where tsid=#{tsid}")
    int update(Topupsetinfo topupsetinfo);



    //查询消费记录
    @Select("select \n" +
            "(select pname from programinfo p where p.pid=b.pid) as pname,\n" +
            "if(b.ctid=0,'全本',(select title   from chapterinfo t where t.ctid=b.ctid)) as title,\n" +
            "purchaservc,buydate,purchasermoney,f.front_username,f.front_userphone\n" +
            "from buy b left join front_user f\n" +
            "on b.purchaser=f.front_userid \n" +
            "order by buydate desc ")
    List<Map<String,Object>> selecttopset();
}
