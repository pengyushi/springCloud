package com.spy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on 2018/12/25.
 */
@SpringBootApplication
@EnableEurekaClient//将当前项目标记为 eureka 客户端
public class OrderApp {

    @Bean// 相当于 xml中的 bean标签
    public RestTemplate get(){
        return new RestTemplate();

    }
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class);
    }
}
