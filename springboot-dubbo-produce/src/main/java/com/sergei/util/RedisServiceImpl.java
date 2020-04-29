package com.sergei.util;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author sergei
 * @create 2020-02-28
 */

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, Object value) {
        stringRedisTemplate.opsForValue().set(key, (String) value);
    }

    @Override
    public void set(String key, Object value, int seconds) {
        stringRedisTemplate.opsForValue().set(key, (String) value,seconds);
    }

    @Override
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public String get(String key) {
        return (String) stringRedisTemplate.opsForValue().get(key);
    }
}
