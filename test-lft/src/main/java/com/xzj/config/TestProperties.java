package com.xzj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "test")
public class TestProperties {
//    环境地址
    private String host;

//    集团 companyKey
    private String companyKey;

//    集团 companySecret
    private String companySecret;

//    公司税号
    private String tax;
}
