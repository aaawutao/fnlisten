package com.aaa.dao;

import com.aaa.entity.Anchorinfo;
import org.apache.ibatis.annotations.*;

import java.util.Map;
import java.util.List;

@Mapper
public interface AnchorinfoDao extends tk.mybatis.mapper.common.Mapper<Anchorinfo> {

    //查询是否存在主播
    @Select("select count(bfid) from anchorinfo where bfid=#{bifd};")
    int queryBybfid(Integer bifd);

    @Update("update anchorinfo set petname=#{petname} where bfid=#{bfid}")
    int updatePetname(@Param("petname") String petname,@Param("bfid") Integer bfid);

    @Select("select acid from anchorinfo where actype=1 and bfid=#{userid}")
    Integer queryactid(@Param("userid") Integer userid);

    @Insert("insert into anchorinfo (actype,bfid,petname) values(1,#{front_userid},#{petname})")
    int addanchor(@Param("front_userid") Integer front_userid, @Param("petname") String petname);

    //显示
    @SelectProvider(type = AnchorinfoSql.class, method = "querySql")
    public List<Map<String, Object>> query(@Param("actype") Integer actype, @Param("num") Integer num);


    class AnchorinfoSql {
        public String querySql(@Param("actype") Integer actype, @Param("num") Integer num) {
            StringBuffer sql = new StringBuffer("");
            if (actype == 0) {
                sql.append("select a.*,bu.* from anchorinfo a\n" +
                        " left join backstage_user bu\n" +
                        "on a.bfid=bu.backstage_userid where actype=0 ");
            } else if (actype == 1) {
                sql.append("select a.*,fu.* from anchorinfo a\n" +
                        "left join front_user fu\n" +
                        "on a.bfid=fu.front_userid where actype=1 ");
            }
            if (num != null) {
                sql.append(" limit #{num}");
            }
            return sql.toString();
        }
    }
}
