package com.aaa.security;


import com.aaa.entity.Backstage_User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Component("rbacConfig")
public class RbacConfig {

    /**
     * 核心就是判断当前的用户所拥有的URL是否和当前访问的URL是否匹配
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        //boolean hasPermission = false;
        /*Object principal = authentication.getPrincipal();
        // 核心就是判断当前的用户所拥有的URL是否和当前访问的URL是否匹配。
        if(principal instanceof UserDetails){
            Backstage_User usertest =(Backstage_User) principal;
            // 获取请求路径
            String uri = request.getRequestURI();
            System.out.println(uri);
            // 从数据库中查询可以访问的路径有哪些,判断 hasPermission=true;
        }*/
        return true;
    }
}
