package com.aaa.dao;

import com.aaa.entity.Menuinfo;
import org.apache.ibatis.annotations.*;
import org.hibernate.annotations.ListIndexBase;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuInfoDao extends tk.mybatis.mapper.common.Mapper<Menuinfo> {

    //管理员
    @SelectProvider(type = SqlMenu.class,method = "getmuneSql")
    List<Map<String,Object>> getmune(@Param("userid") Integer userid,@Param("pid") Integer pid,@Param("menutype") Integer menutype);



    //普通管理员
    @SelectProvider(type = SqlMenu.class,method = "getcommonSql")
    List<Map<String,Object>> getcommonmune(@Param("pid")Integer pid,@Param("menutype") Integer menutype);

    //部门所拥有的权限
    @Select("select menuid from department_menu where bid=#{bid}")
    List<Map<String,Object>> getdeptmune(@Param("bid") Integer did);


    //权限分配
    //删除已有权限
    @Delete("delete from department_menu where bid=#{bid}")
    Integer delPermission(@Param("bid") Integer did);

    //添加现有权限
    @Insert("insert into department_menu values (#{bid},#{menuid})")
    Integer addPermisssion(@Param("bid") Integer did,@Param("menuid") Integer menuid);







    //sql
    class SqlMenu{
        public String getcommonSql(@Param("pid")Integer pid,@Param("menutype") Integer menutype){
            StringBuffer sql=new StringBuffer("select id,menuname,menuurl,parentId from menuinfo where 1=1 ");
            if(menutype!=null){
                sql.append(" and menutype="+menutype);
            }
            if(pid!=null){
                sql.append(" and parentId="+pid);
            }
            return sql.toString();
        }



        public String  getmuneSql(@Param("userid") Integer userid,@Param("pid") Integer pid,@Param("menutype") Integer menutype){
            StringBuffer sql = new StringBuffer("select m.id,m.menuname,m.menuurl,m.parentId from department_menu dm\n" +
                    "left join menuinfo m\n" +
                    "on m.id=dm.menuid\n" +
                    "left join departmentinfo  d\n" +
                    "on dm.bid=d.did\n" +
                    "left join empinfo e\n" +
                    "on d.did=e.did\n" +
                    "left join backstage_user bu\n" +
                    "on bu.empid=e.empid where 1=1 ");
            if(userid!=null){
                sql.append(" and bu.backstage_userid=#{userid}");
            }
            if(pid!=null){
                sql.append(" and m.parentId=#{pid}");
            }
            if(menutype!=null){
                sql.append(" and m.menutype=#{menutype}");
            }
            return sql.toString();
        }
    }


}
