package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configure resource handling.
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/angular/")  // Specify the location of your Angular app's static files.
                .resourceChain(false)  // Disable resource chain (useful for development).
                .addResolver(new PathResourceResolver());
    }
}
