package com.sergei.demo;

import com.alibaba.fastjson.JSON;

/**
 * @author sergei
 * @create 2020-03-25
 */
public class MyJsonService {
    private String name;

    /**
     * 使用 fastjson 将对象转换为 json 字符串输出
     *
     * @param object 传入的对象
     * @return 输出的字符串
     */
    public String objToJson(Object object) {
        return getName() + JSON.toJSONString(object);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
