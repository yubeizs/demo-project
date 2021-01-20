package com.example.demoproject.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport  {

    @Bean
    public TestInterceptor testInterceptor(){
        return new TestInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // 拦截所以请求。。
        registry.addInterceptor(this.testInterceptor()).addPathPatterns("/**");
    }
}
