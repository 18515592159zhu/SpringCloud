package com.itheima.consumer.client;

import com.itheima.consumer.client.fallback.UserClientFallback;
import com.itheima.consumer.config.FeignConfig;
import com.itheima.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 声明当前是一个Feign客户端，指定服务名为user-service
@FeignClient(value = "user-service", fallback = UserClientFallback.class, configuration = FeignConfig.class)
@Component("userClient")
public interface UserClient {

    // http://user-service/user/12
    @GetMapping("/user/{id}")
    public User queryById(@PathVariable(value = "id") Long id);
}