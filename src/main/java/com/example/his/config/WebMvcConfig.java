package com.example.his.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@Slf4j
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
            log.info("进行静态资源映射");
            registry.addResourceHandler("/static/**").addResourceLocations("classPath:/static/");
            registry.addResourceHandler("/backend/**").addResourceLocations("classPath:/backend/");
    }
}
