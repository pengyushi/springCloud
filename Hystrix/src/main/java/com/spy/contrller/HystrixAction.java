package com.spy.contrller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by lenovo on 2018/12/25.
 */
@RestController
public class HystrixAction {

    @Autowired
    private EurekaClient eurekaClient;
    @Value("${order.url}")
    private String url;
    @Autowired
    private RestTemplate restTemplate; //spring 提供的一个用于访问 rest 接口的模板对象
    @GetMapping("/hystrix/{id}")
    //当访问失败报错的时候调用 shibai 方法
    @HystrixCommand(fallbackMethod = "shibai",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
    //"execution.isolation.strategy" 默认不建议大家修改,如果大家遇到问题了再修改,否则不建议 加上这个就在同一个线程了
    public User getOrder(@PathVariable Long id){
        InstanceInfo user = eurekaClient.getNextServerFromEureka("USER", false);
        String homePageUrl = user.getHomePageUrl();
        //访问提供者获取数据  1 服务者的地址  2.接收参数类型
        User forObject = restTemplate.getForObject(homePageUrl +"/user/"+ id, User.class);
        return forObject;
    }
    public User shibai( Long id){
        User user = new User();
        user.setId(100L);
        user.setDate(new Date());
        return user;
    }
}
