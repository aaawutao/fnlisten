package com.aaa.service;

import com.aaa.dao.Backstage_UserDao;
import com.aaa.entity.Anchorinfo;
import com.aaa.entity.Backstage_User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Backstage_UserService  {
    @Resource
    Backstage_UserDao backstage_userDao;
    /**
     * 头像做修改
     */
    public Integer editPhoto(String userid,String photo){
        return backstage_userDao.photoupload(userid,photo);
    }


    /**
     * 校验用户名
     *
     */
    public Backstage_User checkUserName(String name){
         Backstage_User user=new Backstage_User();
         user.setBackstage_uname(name);
        return backstage_userDao.selectOne(user);
    }

    /**
     * 查询用户信息
     */
    public PageInfo<Backstage_User> findAll(Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Backstage_User> userall = backstage_userDao.queryAll();
        PageInfo<Backstage_User> pageInfo = new PageInfo<>(userall);
        return pageInfo;
    }

    /**
     * 启用禁用用户
     */
    public int updateFlag(Integer isenable,Integer backstage_userid){
        return  backstage_userDao.updateFlag(isenable,backstage_userid);
    }

    /**
     * 添加账号到给用户
     */
    public int insertBackstageUser(Backstage_User backstage_user){
        return backstage_userDao.insertBackstageUser(backstage_user);
    }
    /**
     * 员工部门添加部门
     */
    public int insertdept(Integer did,Integer empid){
        return backstage_userDao.insertdept(did, empid);
    }


    /**
     * 修改用户密码
     * @param
     * @return
     */

    //查询出账号下的用户详细信息
    public List<Map<String,Object>> queryBydetails(Integer backstage_userid){

        return  backstage_userDao.queryByUserdetails(backstage_userid);
    }

    //查询出主播表的actype是否是0
    public Anchorinfo queryByZb(Integer bfid){
          return   backstage_userDao.queryByZb(bfid);
    }

    //修改图片
   public int  updatephoto(String backstage_photo,Integer backstage_userid){
        return  backstage_userDao.updatephoto(backstage_photo,backstage_userid);
    }
    //修改密码
    public int updatepwd(String backstage_upwd,Integer backstage_userid){

        return backstage_userDao.updatepwd(backstage_upwd,backstage_userid);
    }
}
