package com.xzj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "driver")
public class DriverProperties {
//    新增司机
    private String create;

//    删除司机
    private String delete;

//    编辑司机
    private String update;

//    查询司机
    private String select;
}
