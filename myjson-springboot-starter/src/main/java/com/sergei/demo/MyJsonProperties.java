package com.sergei.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sergei
 * @create 2020-03-25
 */
@ConfigurationProperties(prefix = "sergei.json")
public class MyJsonProperties {
    public static final String DEFAULT_NAME = "sergei";

    private String name = DEFAULT_NAME;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
