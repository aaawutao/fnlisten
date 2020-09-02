package com.aaa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class FileConfig implements WebMvcConfigurer {
    //上传路径
    @Value("${prop.filepath}")
String staticurl;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(("/staticfile/**")).addResourceLocations("file:"+staticurl);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
