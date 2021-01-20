package com.example.demoproject.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class FilterConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean<>();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName","paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 自定义过滤器
     */
    public class MyFilter implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
                // todo sth
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("前端请求URL："+request.getRequestURI());
            //继续传递
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {
                // todo sth
        }
    }
}
