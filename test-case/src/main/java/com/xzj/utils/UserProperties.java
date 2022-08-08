package com.xzj.utils;

import com.xzj.dto.InterfaceName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static com.xzj.dto.InterfaceName.*;

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
