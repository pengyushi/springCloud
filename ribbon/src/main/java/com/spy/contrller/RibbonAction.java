package com.spy.contrller;

import com.netflix.discovery.EurekaClient;
import com.spy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on 2018/12/25.
 */
@RestController
public class RibbonAction {

    @Autowired
    private EurekaClient eurekaClient;
    @Value("${order.url}")
    private String url;
    @Autowired
    private RestTemplate restTemplate; //spring 提供的一个用于访问 rest 接口的模板对象
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/ribbon/{id}")
    public User getOrder(@PathVariable Long id){
//        InstanceInfo user = eurekaClient.getNextServerFromEureka("USER", false);
//        String homePageUrl = user.getHomePageUrl();
        //访问提供者获取数据  1 服务者的地址  2.接收参数类型
       // User forObject = restTemplate.getForObject(homePageUrl +"/user/"+ id, User.class);
        //使用ribbon 后就可以将地址变成 服务的名字
        User forObject = restTemplate.getForObject("http://USER/user/"+ id, User.class);
        return forObject;
    }
    @GetMapping("/test")
    public void test(){
        //查找对应服务器的实例 会通过负载均衡算法返回一个  默认使用的是轮询
        ServiceInstance user = loadBalancerClient.choose("USER");
        System.out.println(user.getHost());//地址
        System.out.println(user.getPort());//端口号
        System.out.println(user.getServiceId());//服务名字
        System.out.println(user.getUri());//服务地址
    }
}
