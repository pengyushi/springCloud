package com.spy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by lenovo on 2018/12/25.
 */
@SpringBootApplication
@EnableEurekaClient//将当前项目标记为 eureka 客户端
@EnableFeignClients //表示这是 feign 的客户端
@EnableCircuitBreaker //启用熔断
public class FeignHystrixApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixApp.class);
    }
}
