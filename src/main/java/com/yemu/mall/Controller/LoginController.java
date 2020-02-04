package com.yemu.mall.Controller;

import com.yemu.mall.Common.Response;
import com.yemu.mall.Service.LoginService;
import com.yemu.mall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@Validated
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Response Login(User user){
        return loginService.Login(user);
    }
}
