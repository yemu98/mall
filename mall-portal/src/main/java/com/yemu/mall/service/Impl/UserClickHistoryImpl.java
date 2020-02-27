package com.yemu.mall.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.entity.UserClickHistory;
import com.yemu.mall.mapper.UserClickHistoryMapper;
import com.yemu.mall.service.UserClickHistoryService;
import org.springframework.stereotype.Service;

@Service
public class UserClickHistoryImpl extends ServiceImpl<UserClickHistoryMapper,UserClickHistory> implements UserClickHistoryService {
}
