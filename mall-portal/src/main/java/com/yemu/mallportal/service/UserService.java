package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.common.Response;
import com.yemu.mallportal.entity.User;

public interface UserService extends IService<User> {
    User findUserByName( String name);
    User findUserByPhone(String phone);
    boolean existUserByPhone(String phone);
    Response<User> register(User user);
}
