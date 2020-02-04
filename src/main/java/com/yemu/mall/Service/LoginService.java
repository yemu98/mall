package com.yemu.mall.Service;

import com.yemu.mall.Common.Response;
import com.yemu.mall.entity.User;

public interface LoginService {
    Response Login(User user);
}
