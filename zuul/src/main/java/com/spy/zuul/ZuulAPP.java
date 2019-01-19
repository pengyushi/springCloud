package com.spy.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by lenovo on 2019/1/19.
 */
@SpringBootApplication
@EnableZuulProxy //启用 zuul 自带 eureka 熔断
public class ZuulAPP {

    public static void main(String[] args) {
        SpringApplication.run(ZuulAPP.class,args);
    }
}
