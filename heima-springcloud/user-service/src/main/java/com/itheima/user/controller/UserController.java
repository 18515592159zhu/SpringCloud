package com.itheima.user.controller;

import com.itheima.user.pojo.User;
import com.itheima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope // 刷新配置
public class UserController {

    @Value("${test.name}")
    private String name;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryByuId(@PathVariable Long id) {
        System.out.println("配置文件中的test.name = " + name);
        return userService.queryById(id);
    }
}








