package com.aaa.conflg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class FileServerConfig implements WebMvcConfigurer {

    @Value("${prop.filepath}")
    String staticurl;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/staticfile/**").addResourceLocations("file:/"+staticurl);
        WebMvcConfigurer.super.addResourceHandlers(registry);// http:/backstage/staticfile/图片
    }

}
