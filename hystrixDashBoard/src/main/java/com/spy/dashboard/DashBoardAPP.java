package com.spy.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by lenovo on 2019/1/19.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardAPP {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardAPP.class);
    }
}
