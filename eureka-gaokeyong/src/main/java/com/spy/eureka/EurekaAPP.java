package com.spy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by lenovo on 2019/1/6.
 */
@SpringBootApplication
@EnableEurekaServer//将当前项目标记为 eureka server
public class EurekaAPP {
    public static void main(String[] args) {
        SpringApplication.run(EurekaAPP.class);
    }
}
