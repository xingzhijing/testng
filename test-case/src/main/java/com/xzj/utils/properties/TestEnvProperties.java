package com.xzj.utils.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "test-env")
public class TestEnvProperties {
    private String url;

    private String login;

    private String loginInterface;

    private String userName;

    private String password;

}
