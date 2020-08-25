package com.aaa.dao;

import com.aaa.entity.Menuinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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




    //sql
    class SqlMenu{
        public String getcommonSql(@Param("pid")Integer pid,@Param("menutype") Integer menutype){
            StringBuffer sql=new StringBuffer("select menuid,menuname,menuurl from menuinfo where 1=1 ");
            if(menutype!=null){
                sql.append(" and menutype="+menutype);
            }
            if(pid!=null){
                sql.append(" and menuparentid="+pid);
            }
            return sql.toString();
        }



        public String  getmuneSql(@Param("userid") Integer userid,@Param("pid") Integer pid,@Param("menutype") Integer menutype){
            StringBuffer sql = new StringBuffer("select m.menuid,m.menuname,m.menuurl from department_menu dm\n" +
                    "left join menuinfo m\n" +
                    "on m.menuid=dm.menuid\n" +
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
                sql.append(" and m.menuparentid=#{pid}");
            }
            if(menutype!=null){
                sql.append(" and m.menutype=#{menutype}");
            }
            return sql.toString();
        }
    }


}
