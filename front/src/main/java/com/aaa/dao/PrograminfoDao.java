package com.aaa.dao;

import com.aaa.entity.Programinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface PrograminfoDao extends tk.mybatis.mapper.common.Mapper<Programinfo> {


    @Select("select p.pid,p.pname,p.poster,p.pintroduction,p.ptid,p.psource,p.anchortid,p.chapterorder,\n" +
            "p.pcreatedate,p.buycount,p.pstate,p.allprice,p.pstatus,a.petname,pt.ptname \n" +
            "from programinfo p \n" +
            "left join  anchorinfo a \n" +
            "on p.anchortid=a.acid  \n" +
            "left join programtypeinfo pt \n" +
            "on p.ptid=pt.ptid")
    List<Map<String,Object>> queryAll();


    @SelectProvider(type = SqlPrograminfo.class, method = "querySql")
    List<Map<String, Object>> query(@Param("pid") Integer pid, @Param("ptid") Integer ptid, @Param("anchortid") Integer anchortid, @Param("num") Integer num);

    @Select("update programinfo set buycount=(buycount+1) where pid=#{pid}")
    Integer updateBuycount(@Param("pid") Integer pid);

    //定义sql
    class SqlPrograminfo {
        public String querySql(@Param("pid") Integer pid, @Param("ptid") Integer ptid, @Param("anchortid") Integer anchortid, @Param("num") Integer num) {
            StringBuffer sql = new StringBuffer("select\n" +
                    "p.pid,p.pname,p.poster,p.pintroduction,p.ptid,p.psource,p.anchortid,p.chapterorder,\n" +
                    "p.pcreatedate,p.buycount,p.pstate,p.allprice,p.pstatus,a.petname,pt.ptname,a.actype,a.bfid\n" +
                    "from programinfo p\n" +
                    "left join  anchorinfo a\n" +
                    "on p.anchortid=a.acid \n" +
                    "left join programtypeinfo pt\n" +
                    "on p.ptid=pt.ptid\n" +
                    "where 1=1 and p.pstatus=0");
            if (pid != null) {
                sql.append(" and p.pid=#{pid}");
            }
            if (ptid != null) {
                sql.append(" and p.ptid=#{ptid}");
            }
            if (anchortid != null) {
                sql.append(" and p.anchortid=#{anchortid}");
            }

            sql.append(" order by p.buycount desc");
            if (num != null) {
                sql.append(" limit #{num}");
            }
            return sql.toString();
        }
    }
}
