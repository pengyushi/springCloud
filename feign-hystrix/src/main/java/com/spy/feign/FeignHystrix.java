package com.spy.feign;

import com.spy.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lenovo on 2019/1/19.
 */
//当 feign 失败的时候 会调用这个类 相应的 方法
@Component
public class FeignHystrix implements FeignHystrixClient01 {
    @Override
    public User getorder(Long id) {
        User user = new User();
        user.setDate(new Date());
        user.setId(1000L);
        return user;
    }

    @Override
    public User getUser(User user) {
        return user;
    }
}
