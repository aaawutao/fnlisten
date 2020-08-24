package com.aaa.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class FileServerConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/staticfile/**").addResourceLocations("file:/E:/listenfile/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
