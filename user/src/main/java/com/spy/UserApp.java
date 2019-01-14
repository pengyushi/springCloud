package com.spy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动springboot的主程序
 */
@SpringBootApplication
@EnableEurekaClient// 启动 eureka 客户端
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class);
    }
}
