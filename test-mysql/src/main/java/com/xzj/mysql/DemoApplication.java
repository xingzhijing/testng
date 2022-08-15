package com.xzj.mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//设置mapper接口的扫描包
@MapperScan(basePackages = "com.xzj.mysql.mapper")
@SpringBootApplication(scanBasePackages = "com.xzj.mysql")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
