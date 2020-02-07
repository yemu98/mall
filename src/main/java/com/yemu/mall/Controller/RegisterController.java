package com.yemu.mall.Controller;

import com.yemu.mall.Common.Response;
import com.yemu.mall.Service.UserService;
import com.yemu.mall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response register(@Valid User user){
        return userService.register(user);
    }
}
