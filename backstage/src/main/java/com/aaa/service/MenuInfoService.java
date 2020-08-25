package com.aaa.service;

import com.aaa.dao.MenuInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

@Service
public class MenuInfoService {
    @Resource
    MenuInfoDao menuInfoDao;

    public List<Map<String,Object>> test(){
        return menuInfoDao.getcommonmune(null,0);
    }
    //


    //全部查询菜单
    public List<Map<String,Object>> all(){
        List<Map<String,Object>> mune=menuInfoDao.getcommonmune(null,0);
        for(Map<String,Object> one:mune){

            List<Map<String,Object>> zimune=menuInfoDao.getcommonmune(Integer.parseInt(one.get("menuid").toString()),1);
            for(Map<String,Object> btns:zimune){
                //设置第第三层菜单
                btns.put("btns",menuInfoDao.getcommonmune(Integer.parseInt(btns.get("menuid").toString()),2));
            }
            one.put("zi",zimune);
        }
        return mune;
    }
    //查询用户所拥有的菜单
    public List<Map<String,Object>> usermune(Integer userid){
        List<Map<String,Object>> mune=menuInfoDao.getmune(userid,null,0);
        for(Map<String,Object> one:mune){
            List<Map<String,Object>> zimune=menuInfoDao.getmune(userid,Integer.parseInt(one.get("menuid").toString()),1);
            for(Map<String,Object> btns:zimune){
                //设置第第三层菜单
                btns.put("btns",menuInfoDao.getmune(userid,Integer.parseInt(btns.get("menuid").toString()),2));
            }
            one.put("zi",zimune);
        }
        return mune;
    }




}
