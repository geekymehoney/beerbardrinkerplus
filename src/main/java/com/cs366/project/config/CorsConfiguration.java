package com.cs366.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("*");
        registry.addMapping("/**").allowedMethods("GET");
    }
}
