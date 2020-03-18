package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.UserUnlike;
import com.yemu.mallportal.mapper.UserUnlikeMapper;
import com.yemu.mallportal.service.UserUnlikeService;
import org.springframework.stereotype.Service;

@Service
public class UserUnlikeImpl extends ServiceImpl<UserUnlikeMapper, UserUnlike> implements UserUnlikeService {
}
