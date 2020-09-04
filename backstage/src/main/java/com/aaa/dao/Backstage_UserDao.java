package com.aaa.dao;

import com.aaa.entity.Anchorinfo;
import com.aaa.entity.Backstage_User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Backstage_UserDao extends Mapper<Backstage_User> {

    @Update("update backstage_user set isenable=#{isenable} where backstage_userid=#{backstage_userid}")
    int updateFlag(@Param("isenable") Integer isenable, @Param("backstage_userid") Integer backstage_userid);

    //添加账号到给用户
    @Insert("insert into backstage_user (backstage_uname,backstage_upwd,empid) values (#{backstage_uname},#{backstage_upwd},#{empid})")
    @Options(useGeneratedKeys = true, keyProperty = "backstage_userid")
//添加成功是获取自增的主键编号
    int insertBackstageUser(Backstage_User backstage_user);

    //员工部门添加部门
    @Update("update  empinfo set did=#{did} where empid=#{empid}")
    int insertdept(@Param("did") Integer did, @Param("empid") Integer empid);

    //用户图片修改
    @Update("update backstage_user  set backstage_photo=#{photo} where backstage_userid=#{userid}")
    Integer photoupload(@Param("userid") String userid, @Param("photo") String backstage_photo);


    @Select("select * from backstage_user where backstage_userid!=1 ")
    List<Backstage_User> queryAll();

    //查询出账号下的用户详细信息
    @Select("select bu.*,dtp.dname,ei.* from backstage_user  bu\n" +
            "left join empinfo ei \n" +
            "on bu.empid=ei.empid\n" +
            "left join departmentinfo dtp\n" +
            "on dtp.did=ei.did\n" +
            "where bu.backstage_userid=#{backstage_userid}")
    List<Map<String, Object>> queryByUserdetails(@Param("backstage_userid") Integer backstage_userid);

    //查询出主播表的actype是否是0
    @Select("select * from anchorinfo where bfid=#{bfid}")
    Anchorinfo queryByZb(@Param("bfid") Integer bfid);

    //修改图片
    @Update("update backstage_user \n" +
            "set backstage_photo= #{backstage_photo}\n" +
            "where backstage_userid=#{backstage_userid}\n")
    int updatephoto(@Param("backstage_photo") String backstage_photo,@Param("backstage_userid") Integer backstage_userid);


    @Update("update backstage_user " +
            "set backstage_upwd=#{backstage_upwd} " +
            "where backstage_userid=#{backstage_userid}")
    int updatepwd(@Param("backstage_upwd") String backstage_upwd,@Param("backstage_userid") Integer backstage_userid);
}


