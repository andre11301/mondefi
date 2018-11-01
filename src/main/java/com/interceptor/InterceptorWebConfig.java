package com.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 */
@Configuration
public class InterceptorWebConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addpathPatterns ={
                "/boot/**"
        };
        String[] excludePathPatterns ={
                "/static/**"
        };

        registry.addInterceptor(new LoginSercurityInerceptor())
                .addPathPatterns(addpathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");//
    }


}
