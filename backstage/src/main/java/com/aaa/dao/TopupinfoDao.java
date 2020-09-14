package com.aaa.dao;

import com.aaa.entity.Topupinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@org.apache.ibatis.annotations.Mapper
public interface TopupinfoDao extends Mapper<Topupinfo> {


    //查询所有的用户充值记录
    @SelectProvider(type = SqlMenu.class,method = "gettopSql")
    List<Map<String,Object>> querytopupi(@Param("front_userphone") String front_userphone);



    //sql
    class SqlMenu {
        public String gettopSql(@Param("front_userphone") String front_userphone) {
            StringBuffer sql = new StringBuffer("select ti.*,tpi.*,fu.front_username,fu.front_userphone from topupinfo ti \n" +
                    "left join topupsetinfo tpi \n" +
                    "on ti.tsid=tpi.tsid \n" +
                    "left join front_user fu \n" +
                    "on fu.front_userid=ti.front_userid " +
                    " where 1=1  ");
            if (front_userphone!=null){
                sql.append("and front_userphone like '%${front_userphone}%'");
            }
            sql.append("order by topupdate desc");
            return sql.toString();
        }
    }

}
