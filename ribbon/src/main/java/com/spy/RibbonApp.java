package com.spy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on 2018/12/25.
 */
@SpringBootApplication
@EnableEurekaClient//将当前项目标记为 eureka 客户端
@RibbonClient(name="USER",configuration = RibbonConfig.class)//启动ribbon 并对 USER 进行负载均衡
//表示 在扫描的时候 不会扫描有这个注解的类
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = spy.class)})
public class RibbonApp {

    @Bean// 相当于 xml中的 bean标签
    public RestTemplate get(){
        return new RestTemplate();

    }
    public static void main(String[] args) {
        SpringApplication.run(RibbonApp.class);
    }
}
