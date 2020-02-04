package com.yemu.mall.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mall.entity.User;

public interface UserService extends IService<User> {
    int insertUser( User user);
    int updateUser( User user);
    int deleteUser(User user);
    User findUserByName( String name);
}
