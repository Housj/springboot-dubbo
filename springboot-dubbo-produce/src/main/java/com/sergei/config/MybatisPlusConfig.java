package com.sergei.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author sergei
 * @create 2020-03-17
 */
@Configuration
@MapperScan(value = "com.sergei.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    //开启后会出现分页插件冲突
//    @Bean
//    public PageInterceptor pageInterceptor(){
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable","true");
//        pageInterceptor.setProperties(properties);
//        return pageInterceptor;
//    }

}
