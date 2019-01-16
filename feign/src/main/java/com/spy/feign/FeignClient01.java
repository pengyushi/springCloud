package com.spy.feign;

import com.spy.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lenovo on 2019/1/16.
 */
@FeignClient("user")//这是服务提供者的名字
public interface FeignClient01 {
    //@GetMapping("/user/{id}")//这个是服务里面的方法
    @RequestLine("GET /user/{id}")//这是feign提供的注解 1 请求方式 2 请求地址 用空格分隔
    //注意 使用 RequestLine的时候  @PathVariable要改成 @Param
//    User getorder( @PathVariable("id") Long id);
    User getorder( @Param("id") Long id);
    @GetMapping("/getUser")//这个是服务里面的方法 无法访问 复杂参数服务哪里需要修改为 post 如果要传递多个对象,只能以普通方式传递,不能封装成对象
    User getUser( User user);//feign 传递复杂参数的时候 不管设置的是什么方式,都会已post的方式进行发送

}