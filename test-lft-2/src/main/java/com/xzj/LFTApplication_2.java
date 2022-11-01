package com.xzj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xzj")
@MapperScan(basePackages = "com.xzj.mapper")
public class LFTApplication_2 {
    public static void main(String[] args) {
        try {
            SpringApplication.run(LFTApplication_2.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
