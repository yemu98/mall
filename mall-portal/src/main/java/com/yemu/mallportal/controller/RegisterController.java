package com.yemu.mallportal.controller;

import com.yemu.mall.common.Response;
import com.yemu.mallportal.entity.User;
import com.yemu.mallportal.service.UserService;
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
