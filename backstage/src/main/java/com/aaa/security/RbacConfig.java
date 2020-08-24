package com.aaa.security;


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
        boolean hasPermission = false;
        Object principal = authentication.getPrincipal();
        // 判断是否可以获取用户信息：是否已经认证完成
        if(principal instanceof UserDetails){
           /* Usertest usertest = (Usertest) principal;
            // 获取请求路径
            String uri = request.getRequestURI();

            // 从数据库中查询可以访问的路径有哪些，判断 hasPermission=true;
            List<Map<String,Object>> list=usertest.getUrls();
            if(list.get(0)!=null){
                for(Map<String,Object> map:list){
                    if(map.get("MURL").equals(uri)){
                        hasPermission=true;
                        break;
                    }
                }
            }*/
        }
        return true;
    }
}
