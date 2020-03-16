package com.yemu.mallportal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mallportal.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User getUserByName(String userName);
    User getUserByPhone(String phone);
}
