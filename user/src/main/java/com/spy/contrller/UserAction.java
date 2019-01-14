package com.spy.contrller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/12/25.
 */
@RestController
public class UserAction {
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){

        return new User(id);
    }

    @GetMapping("/s/{id}")
    public String gets(@PathVariable Long id){
        return "nihao"+id;
    }

    //使用 eureka client
    @GetMapping("/eurekainfo")
    public String info(){
        //  user 是服务的名字  这个可以得到服务器的 地址
        InstanceInfo user = eurekaClient.getNextServerFromEureka("USER", false);
        return user.getHomePageUrl();
    }
}
