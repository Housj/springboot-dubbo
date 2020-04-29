package com.example.springbootdubboprivider.config;

import com.example.springbootdubboprivider.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sergei
 * @create 2020-03-17
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","login.html")
//                .excludePathPatterns();
//    }
}
