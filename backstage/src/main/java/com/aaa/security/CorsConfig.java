package com.aaa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    /**
     * 配置跨域过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        // 跨域请求配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许请求携带验证信息
        corsConfiguration.setAllowCredentials(true);
        // 允许请求域名
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        // 允许访问的请求方式
        //corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.setAllowedMethods(Arrays.asList("POST","GET"));

        // 基于请求路径的跨域解析
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }

}
