package com.aaa.dao;

import com.aaa.entity.Menuinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hibernate.annotations.ListIndexBase;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuInfoDao extends tk.mybatis.mapper.common.Mapper<Menuinfo> {

    //父级菜单
    @Select("select m.menuid,m.menuname,m.menuurl from department_menu dm\n" +
            "left join menuinfo m\n" +
            "on m.menuid=dm.menuid\n" +
            "left join departmentinfo  d\n" +
            "on dm.bid=d.did\n" +
            "left join empinfo e\n" +
            "on d.did=e.did\n" +
            "left join backstage_user bu\n" +
            "on bu.empid=e.empid where m.menutype=0 and bu.backstage_userid=#{userid}")
    List<Map<String,Object>> getmuneParent(@Param("userid") Integer userid);



    //子级菜单
    @Select("select menuid,menuname,menuurl from menuinfo where menuparentid=#{pid}")
    List<Map<String,Object>> getmuneChildren(@Param("pid")Integer pid);


    //用户所拥有后台路径



    //sql
    class SqlMenu{
        public String  getmuneParent(@Param("userid") Integer userid,@Param("pid") Integer pid,@Param("menutype") Integer menutype){
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
                sql.append(" bu.backstage_userid=#{userid}");
            }
            if(pid!=null){
                sql.append(" m.menuparentid=#{pid}");
            }
            if(menutype!=null){
                sql.append(" m.menutype=#{menutype}");
            }

            return sql.toString();
        }
    }


}
