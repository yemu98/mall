package com.yemu.mallportal.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.UserClickHistory;
import com.yemu.mallportal.mapper.UserClickHistoryMapper;
import com.yemu.mallportal.service.UserClickHistoryService;
import org.springframework.stereotype.Service;

@Service
public class UserClickHistoryImpl extends ServiceImpl<UserClickHistoryMapper,UserClickHistory> implements UserClickHistoryService {
}
