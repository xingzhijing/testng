package com.xzj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.xzj.mapper")
@SpringBootApplication(scanBasePackages = "com.xzj")
public class LFTApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(LFTApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
