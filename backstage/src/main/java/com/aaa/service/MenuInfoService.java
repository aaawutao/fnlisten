package com.aaa.service;

import com.aaa.dao.MenuInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class MenuInfoService {
    @Resource
    MenuInfoDao menuInfoDao;

    public List<Map<String,Object>> test(){
        return menuInfoDao.getcommonmune(null,0);
    }
    //全部查询菜单
    public List<Map<String,Object>> all(){
        List<Map<String,Object>> mune=menuInfoDao.getcommonmune(null,0);
        for(Map<String,Object> one:mune){

            List<Map<String,Object>> zimune=menuInfoDao.getcommonmune(Integer.parseInt(one.get("id").toString()),1);
            for(Map<String,Object> btns:zimune){
                //设置第第三层菜单
                List<Map<String,Object>> sanlist=menuInfoDao.getcommonmune(Integer.parseInt(btns.get("id").toString()),2);
                for(Map<String,Object> san:sanlist){
                    san.put("children",new ArrayList<Map<String,Object>>());
                }
                btns.put("children",sanlist);
            }
            one.put("children",zimune);
        }
        return mune;
    }
    //查询用户所拥有的菜单
    public List<Map<String,Object>> usermune(Integer userid){
        List<Map<String,Object>> mune=menuInfoDao.getmune(userid,null,0);
        for(Map<String,Object> one:mune){
            List<Map<String,Object>> zimune=menuInfoDao.getmune(userid,Integer.parseInt(one.get("id").toString()),1);
            for(Map<String,Object> btns:zimune){
                //设置第第三层菜单
                btns.put("children",menuInfoDao.getmune(userid,Integer.parseInt(btns.get("id").toString()),2));
            }
            one.put("children",zimune);
        }
        return mune;
    }
    public List<Map<String,Object>> deptmune(Integer did){
        return menuInfoDao.getdeptmune(did);
    }




}
