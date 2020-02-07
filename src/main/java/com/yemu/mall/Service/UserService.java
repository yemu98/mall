package com.yemu.mall.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mall.Common.Response;
import com.yemu.mall.entity.User;

public interface UserService extends IService<User> {
    User findUserByName( String name);
    User findUserByPhone(String phone);
    boolean existUserByPhone(String phone);
    Response register(User user);
}
