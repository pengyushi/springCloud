package com.spy;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 这个配置类 最好不要被扫描到  如果非要放到能扫描到的地方 那就配置 不让他扫描 在app里面
 * Created by lenovo on 2019/1/14.
 */
@Configuration//表示这是配置类
@spy//表示有这个注解 不会被扫描
public class RibbonConfig {
    @Autowired
    private IClientConfig iClientConfig;

    /**
     * 创建负载均衡算法的方法
     * @param config
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig config) {
    return new RandomRule();//返回随机方法

    }
}
