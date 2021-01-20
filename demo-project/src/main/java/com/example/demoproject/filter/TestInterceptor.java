package com.example.demoproject.filter;

import com.alibaba.fastjson.JSON;
import com.example.demoproject.annotion.TestAnno;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;


public class TestInterceptor implements HandlerInterceptor {

    // 在业务处理器处理请求之前被调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;

            Method method = handlerMethod.getMethod();
            System.out.println(method);
            Class<?> aClass = method.getDeclaringClass();

            TestAnno anno = aClass.getAnnotation(TestAnno.class);
            TestAnno anno1 = method.getAnnotation(TestAnno.class);

            System.out.println("--------------");
            String name = request.getParameter("name");
            System.out.println("name:"+name);
        }
//        System.out.println("输出request"+JSON.toJSON(request));
        return true;
    }
    // 在业务处理器处理请求完成之后，生成视图之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception{
    }
    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception{
    }

}
