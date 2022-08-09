package com.xzj.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "user")
public class UserProperties {
//    配置文件application.yml的接口key
    private String homepage;

    private String add;

    private String delete;

    private String update;

    private String find;
}
