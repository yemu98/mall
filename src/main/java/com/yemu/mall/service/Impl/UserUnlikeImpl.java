package com.yemu.mall.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.entity.UserUnlike;
import com.yemu.mall.mapper.UserUnlikeMapper;
import com.yemu.mall.service.UserUnlikeService;
import org.springframework.stereotype.Service;

@Service
public class UserUnlikeImpl extends ServiceImpl<UserUnlikeMapper, UserUnlike> implements UserUnlikeService {
}
