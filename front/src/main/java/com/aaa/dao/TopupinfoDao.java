package com.aaa.dao;

import com.aaa.entity.Topupinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


import java.util.List;
import java.util.Map;

@Mapper
public interface TopupinfoDao extends tk.mybatis.mapper.common.Mapper<Topupinfo> {
    @Select("update topupinfo \n" +
            "set state=1,paymentid=#{paymentid} where tpid=#{tpid}")
    public Integer editState(@Param("tpid") String tpid, @Param("paymentid") String paymentid);

    @SelectProvider(type = TopupinfoSql.class, method = "showSql")
    public List<Map<String, Object>> show(@Param("tpid") String tpid, @Param("front_userid") Integer front_userid, @Param("order") Integer order);


    class TopupinfoSql {
        public String showSql(@Param("tpid") String tpid, @Param("front_userid") Integer front_userid, @Param("order") Integer order) {
            StringBuffer sql = new StringBuffer("select t.*,ts.* from topupinfo t\n" +
                    "left join topupsetinfo ts\n" +
                    "on t.tpid=ts.tsid where 1=1 and t.state=1 ");
            if (tpid != null) {
                sql.append(" and t.tpid=#{tpid}");
            }
            if (front_userid != null) {
                sql.append(" and t.front_userid=#{front_user} ");
            }
            if (order != null) {
                if (order == 0) {
                    sql.append(" order by t.topupdate desc");
                } else {
                    sql.append(" order by t.topupdate");
                }
            }
            return sql.toString();
        }
    }
}
