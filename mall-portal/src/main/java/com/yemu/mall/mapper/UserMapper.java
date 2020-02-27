package com.yemu.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mall.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User getUserByName(String userName);
    User getUserByPhone(String phone);
}
