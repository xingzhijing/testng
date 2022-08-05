package com.xzj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author xzj
 * @date 2022-08-05
 * @since 1.0.0
 */

@SpringBootApplication
public class ServletInitializer {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ServletInitializer.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
