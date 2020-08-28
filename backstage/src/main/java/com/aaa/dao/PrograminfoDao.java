package com.aaa.dao;

import com.aaa.entity.Programinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface PrograminfoDao extends Mapper<Programinfo> {

    @SelectProvider(type = SqlPrograminfo.class,method = "getSql")
    List<Map<String,Object>> queryAll(@Param("pid") Integer pid);

    class SqlPrograminfo {
        public String getSql(@Param("pid") Integer pid) {
            StringBuffer sql = new StringBuffer("select * from programinfo pgi \n" +
                    "left join programtypeinfo pgt \n" +
                    "on pgi.ptid=pgt.ptid \n" +
                    "left join anchorinfo ari \n" +
                    "on pgi.anchortid=ari.acid  where 1=1  ");
            if(pid !=null){
                sql.append(" and pid=#{pid}");
            }
            return sql.toString();
        }
    }
}
