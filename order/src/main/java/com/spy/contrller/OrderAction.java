package com.spy.contrller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on 2018/12/25.
 */
@RestController
public class OrderAction {

    @Autowired
    private EurekaClient eurekaClient;
    @Value("${order.url}")
    private String url;
    @Autowired
    private RestTemplate restTemplate; //spring 提供的一个用于访问 rest 接口的模板对象
    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id){
        InstanceInfo user = eurekaClient.getNextServerFromEureka("USER", false);
        String homePageUrl = user.getHomePageUrl();
        //访问提供者获取数据  1 服务者的地址  2.接收参数类型
        User forObject = restTemplate.getForObject(homePageUrl +"/user/"+ id, User.class);
        return forObject;
    }
}
