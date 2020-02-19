package com.yemu.mall.controller;

import com.yemu.mall.common.Response;
import com.yemu.mall.entity.User;
import com.yemu.mall.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Validated
public class RegisterController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Response<?> register(@Valid User user){
        return userService.register(user);
    }
}
