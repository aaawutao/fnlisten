package com.aaa.dao;

import com.aaa.entity.FrontUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface FrontuserDao extends Mapper<FrontUser> {

    /*
        @Insert("insert into front_user (front_userphone,front_userpwd) \n" +
                "values " +
                "(#{phone},#{front_userpwd},")
        int addFrontuser(@Param("phone") String phone,@Param("front_userpwd") String front_userpwd);*/
    @Select("select fu.front_userid,fu.front_username,fu.front_userpic,fu.front_userphone,fu.front_userpwd,\n" +
            "fu.front_userstate,fu.front_usercreatedate,fu.front_uservipoutdata,fu.front_userflag,\n" +
            "fu.flag,fu.front_userqqflag,fu.front_usermoney,a.acid,a.actype,a.bfid,a.petname from front_user fu\n" +
            "left join anchorinfo a\n" +
            "on a.actype=1 and a.bfid=fu.front_userid where fu.front_userphone=#{phone} and fu.front_userpwd=#{pwd} ")
    Map<String, Object> login(@Param("phone") String phone, @Param("pwd") String pwd);




    @Update("update front_user set front_uservipoutdata = null where front_userid=#{front_userid}")
    Integer updateDate(@Param("front_userid") Integer front_userid);
    //修改
    @UpdateProvider(type = FrontuserSql.class, method = "updateSql")
    Integer updates( FrontUser frontUser);

    class FrontuserSql {
            public String updateSql( FrontUser frontUser) {
                StringBuffer sql = new StringBuffer("update front_user set ");
                if (frontUser.getFront_username() != null) {
                    sql.append("front_username=#{front_username},");
                }
                if (frontUser.getFront_userpic() != null) {
                    sql.append("front_userpic=#{front_userpic},");
                }
                if (frontUser.getFront_userpwd() != null) {
                    sql.append("front_userpwd=#{front_userpwd},");
                }
                if(frontUser.getFront_userstate()!=null){
                    sql.append("front_userstate=#{front_userstate},");
                }
                if(frontUser.getFront_uservipoutdata()!=null){
                    sql.append("front_uservipoutdata=#{front_uservipoutdata},");
                }
                if(frontUser.getFront_usermoney()!=null){
                        //front_usermoney
                    sql.append("front_usermoney=#{front_usermoney},");
                }
                if(frontUser.getFront_userwd()!=null){
                    sql.append("front_userwd=#{front_userwd},");
                }
                //去掉最后一个逗号
                sql.deleteCharAt(sql.length() - 1);
                sql.append(" where front_userid=#{front_userid}");
                return sql.toString();
            }
    }
    //查询出个人信息
    @Select("select * from front_user where front_userid=#{front_userid}")
    FrontUser queryByuserId(Integer front_userid);

}
