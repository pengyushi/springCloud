package com.spy.contrller;

import com.spy.feign.FeignHystrixClient01;
import com.spy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/12/25.
 */
@RestController
public class FeignHystrixAction {
    @Autowired
  private FeignHystrixClient01 feignClient01;

    @GetMapping("/feignhystrix/{id}")
    private User getUser(@PathVariable Long id){
        User getorder = feignClient01.getorder(id);
        return  getorder;

    }


}
