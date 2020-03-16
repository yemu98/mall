package com.yemu.mallportal.controller;

import com.yemu.mallportal.common.Response;
import com.yemu.mallportal.entity.User;
import com.yemu.mallportal.service.LoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Response<?> login(User user){
        return loginService.login(user);
    }
    @GetMapping("/isLogin")
    public Response<?> isLogin(@RequestHeader(required = false) String token){

        return loginService.isLogin(token);
    }
    @GetMapping("/getId")
    public Response<?> getId(@RequestHeader(required = false)String token){
        try{
            long uid = loginService.getId(token);
            Map<String, Long> map = new HashMap<>();
            map.put("uid",uid);
            return Response.ok(map);
        }
        catch (Exception e){
            e.printStackTrace();
            return Response.error(e.getMessage());
        }

    }
}
