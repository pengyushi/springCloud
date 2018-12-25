package com.spy.contrller;

import com.spy.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/12/25.
 */
@RestController
public class UserAction {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){

        return new User(id);
    }

    @GetMapping("/s/{id}")
    public String gets(@PathVariable Long id){
        return "nihao"+id;
    }

}
