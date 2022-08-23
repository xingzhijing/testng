package com.xzj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
