package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.entity.UserUnlike;

public interface UserUnlikeService extends IService<UserUnlike> {
    boolean contains(int uid, int pid);
    boolean delete(int uid,int pid);
}
