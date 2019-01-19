package com.spy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on 2018/12/25.
 */
@SpringBootApplication
@EnableEurekaClient//将当前项目标记为 eureka 客户端
@EnableCircuitBreaker //启用熔断  就是有大良错误的时候就不请求原始方法了 直接请求错误的那个
public class HystrixApp {

    @Bean// 相当于 xml中的 bean标签
    public RestTemplate get(){
        return new RestTemplate();

    }
    public static void main(String[] args) {
        SpringApplication.run(HystrixApp.class);
    }
}
