package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.entity.UserUnlike;
import com.yemu.mallportal.mapper.UserUnlikeMapper;
import com.yemu.mallportal.service.UserUnlikeService;
import org.springframework.stereotype.Service;

@Service
public class UserUnlikeImpl extends ServiceImpl<UserUnlikeMapper, UserUnlike> implements UserUnlikeService {

    @Override
    public boolean contains(int uid, int pid) {
        QueryWrapper<UserUnlike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid).eq("pid",pid);
        return baseMapper.selectList(queryWrapper).size() > 0;
    }

    @Override
    public boolean delete(int uid, int pid) {
        QueryWrapper<UserUnlike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid).eq("pid",pid);
        return baseMapper.delete(queryWrapper) > 0;
    }
}
