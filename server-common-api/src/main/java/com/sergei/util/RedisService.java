package com.sergei.util;

/**
 * @author sergei
 * @create 2020-02-28
 */
public interface RedisService {

    void set(String key,Object value);

    void set(String key,Object value,int seconds);

    void del(String key);

    String get(String key);
}
