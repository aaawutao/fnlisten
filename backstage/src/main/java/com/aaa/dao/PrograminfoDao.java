package com.aaa.dao;

import com.aaa.entity.Programinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface PrograminfoDao extends Mapper<Programinfo> {

    //修改状态是否展示
    @Update("update programinfo set pstatus=#{pstatus} where pid=#{pid}")
    int updateppstatus(@Param("pstatus") Integer pstatus,@Param("pid") Integer pid);

    @SelectProvider(type = SqlPrograminfo.class,method = "getSql")
    List<Map<String,Object>> queryAll(@Param("bfid") Integer bfid);

    //查询详细信息
    @Select("select * from programinfo pgi  \n" +
            "left join programtypeinfo pgt  \n" +
            "on pgi.ptid=pgt.ptid  \n" +
            "left join anchorinfo ari  \n" +
            "on pgi.anchortid=ari.acid \n" +
            " where   pgi.pid=#{pid}")
    List<Map<String,Object>> querybypid(@Param("pid") Integer pid);

    class SqlPrograminfo {
        public String getSql(@Param("bfid") Integer bfid) {
            StringBuffer sql = new StringBuffer("select * from programinfo pgi \n" +
                    "left join programtypeinfo pgt \n" +
                    "on pgi.ptid=pgt.ptid \n" +
                    "left join anchorinfo ari \n" +
                    "on pgi.anchortid=ari.acid  where 1=1  ");
            if(bfid !=null){
                sql.append(" and bfid=#{bfid}");
            }

            return sql.toString();
        }
    }
}
