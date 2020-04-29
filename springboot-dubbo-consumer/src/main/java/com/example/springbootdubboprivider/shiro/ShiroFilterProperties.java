package com.example.springbootdubboprivider.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author sergei
 * @create 2020-03-19
 */
@Data
@Component
@ConfigurationProperties(prefix = "permission-config")
public class ShiroFilterProperties {
    List<Map<String, String>> perms;
}
