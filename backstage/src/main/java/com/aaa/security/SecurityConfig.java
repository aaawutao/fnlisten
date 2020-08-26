package com.aaa.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;
import java.io.PrintWriter;

/**
 *  权限注解
 *  prePostEnabled
 *  securedEnabled
 *  jsr250Enabled
 */
// 将当前类作为配置类使用
@Configuration
// 启用security
@EnableWebSecurity
// 启用方法注解权限
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
    @Resource
    AccessErrorHandle accessErrorHandle;
    @Resource
    AuthenticationErrorHandle authenticationErrorHandle;
    /**
     * 配置访问请求
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


       /* ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry
               = http.authorizeRequests();
       registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();//让Spring security放行所有preflight request
*/
        // 使用form表单登录
        http.formLogin()
                // 登录的form表单的提交路径
                .loginProcessingUrl("/login-check")
                .usernameParameter("backstage_uname")
                .passwordParameter("backstage_upwd")
                .successHandler((req, res, authentication) -> {
                    //获取数据
                    Object principal = authentication.getPrincipal();
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter out = res.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(principal));
                    out.flush();
                    out.close();
                })
                // 访问失败的处理器
                 .failureHandler((req, res, e) -> {
                     res.setContentType("application/json;charset=utf-8");
                     PrintWriter out = res.getWriter();
                     //输出成json格式
                     out.write("{\"message\":\""+e.getMessage()+"\"}");
                     out.flush();
                     out.close();
                 })
                // 直接访问
                .permitAll()
                .and()
                // 授权请求：设置请求的拦截情况
                .authorizeRequests()
                //让Spring security放行所有preflight request
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                //不做拦截
                .antMatchers("/staticfile/*")
                .permitAll()

//                .antMatchers("departmentinfo/add")
//                .permitAll()
                // 任意请求
                .anyRequest()
                // 验证
                //.authenticated()
                //使用自定义的权限表达式
                .access("@rbacConfig.hasPermission(request,authentication)")
                .and()
                // 支持跨域请求
                .cors()
                .and()
                // 跨域请求
                .csrf()
                // 禁用
                .disable()
                .authorizeRequests()
                .and()
                // 异常处理器
                .exceptionHandling()
                // 拒绝访问
                .accessDeniedHandler(accessErrorHandle)
                // 验证失败
                .authenticationEntryPoint(authenticationErrorHandle);
    }

    @Resource
    PasswordConfig passwordConfig;

    @Resource
    UserConfig userConfig;



    /**
     * 配置认证(身份校验，登录)规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // 密码编码规则
        // new BCryptPasswordEncoder();数据中保存的密码是加密之后的密码
        daoAuthenticationProvider.setPasswordEncoder(passwordConfig);
        // 用户信息获取方式
        daoAuthenticationProvider.setUserDetailsService(userConfig);

        auth.authenticationProvider(daoAuthenticationProvider);
    }



}
