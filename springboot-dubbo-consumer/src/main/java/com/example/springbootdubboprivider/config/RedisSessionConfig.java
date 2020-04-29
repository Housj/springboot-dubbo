package com.example.springbootdubboprivider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.servlet.http.HttpSessionListener;

/**
 * @author sergei
 * @create 2020-03-01
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
//
//    @Bean
//    public HttpSessionListener configureRedisAction(){
//        return new SessionListener();
//    }


    //@Bean
//    public ConfigureRedisAction configureRedisAction() {
//        return ConfigureRedisAction.NO_OP;
//    }
}
