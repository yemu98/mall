package com.yemu.mallportal.service;

import com.yemu.mall.common.Response;
import com.yemu.mallportal.entity.User;

/**
 * @author yemu
 */
public interface LoginService {
    /**
     * 登录
     * @param user 用户信息
     * @return 登录用户信息
     */
    Response<?> login(User user);

    /**
     * 是否已登录
     * @param token token
     * @return true/false
     */
    boolean isLogin(String token);

    /**
     * 根据token获取用户id
     * @param token token
     * @return 用户id
     */
    long getId(String token);
}
