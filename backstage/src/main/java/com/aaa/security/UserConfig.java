package com.aaa.security;


import com.aaa.entity.Backstage_User;
import com.aaa.service.Backstage_UserService;
import com.aaa.service.MenuInfoService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

@Component
public class UserConfig implements UserDetailsService {
    @Resource
    Backstage_UserService backstage_userService;

    @Resource
    MenuInfoService menuInfoService;
    /**
     * 根据用户名获取用户信息
     *
     * @param s 表单提交的用户名
     * @return 用户详细信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //实体类实现userdetails接口
        Backstage_User user = backstage_userService.checkUserName(s);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }else{
            //设置登录用户所管理的路径,如果用户所拥有的全部后台路径
            if(user.getEmpid()==0){

                user.setUrls(menuInfoService.all());
            }else{
                user.setUrls(menuInfoService.usermune(user.getBackstage_userid()));
            }
        }
        return user;
    }

}
