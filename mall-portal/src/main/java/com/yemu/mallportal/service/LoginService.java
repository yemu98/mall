package com.yemu.mallportal.service;

import com.yemu.mall.common.Response;
import com.yemu.mallportal.entity.User;

/**
 * @author yemu
 */
public interface LoginService {
    /**
     * 登录
     * @param user
     * @return 登录用户信息
     */
    Response<User> login(User user);

    /**
     * 是否已登录
     * @param token
     * @return
     */
    Response<String> isLogin(String token);

    /**
     * 根据token获取用户id
     * @param token
     * @return
     */
    long getId(String token);
}
