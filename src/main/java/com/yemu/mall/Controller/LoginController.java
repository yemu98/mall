package com.yemu.mall.Controller;

import com.yemu.mall.Common.Response;
import com.yemu.mall.Common.TokenUtil;
import com.yemu.mall.Service.LoginService;
import com.yemu.mall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Response Login(User user){
        return loginService.Login(user);
    }
    @GetMapping("/isLogin")
    public Response isLogin(@RequestHeader(required = false) String token){
        return loginService.isLogin(token);
    }
}
