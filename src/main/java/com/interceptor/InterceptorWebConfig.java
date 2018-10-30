package com.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

        };

        registry.addInterceptor(new LoginInerceptor())
                .addPathPatterns(addpathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }


}
