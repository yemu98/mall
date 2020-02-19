package com.yemu.mall.service;

import com.yemu.mall.common.Response;
import com.yemu.mall.entity.User;

public interface LoginService {
    Response<User> Login(User user);
    Response<String> isLogin(String token);
    long getId(String token);
}
