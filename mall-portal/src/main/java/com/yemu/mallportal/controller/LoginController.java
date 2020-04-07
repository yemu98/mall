package com.yemu.mallportal.controller;

import com.yemu.mall.common.R;
import com.yemu.mall.common.Response;
import com.yemu.mallportal.Exception.LoginException;
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
    public Response<?> login(User user) {
        return loginService.login(user);
    }

    @GetMapping("/isLogin")
    public R<?> isLogin(@RequestHeader(required = false) String token) {
        try {
            if (loginService.isLogin(token)) {
                return R.ok(true);
            }else {
                return R.error("服务器内部错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof LoginException) {
                return R.error(((LoginException) e).getStatus(), e.getMessage());
            } else {
                return R.error("服务器内部错误");
            }
        }

    }

    @GetMapping("/getId")
    public Response<?> getId(@RequestHeader(required = false) String token) {
        try {
            long uid = loginService.getId(token);
            Map<String, Long> map = new HashMap<>(16);
            map.put("uid", uid);
            return Response.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }

    }
}
