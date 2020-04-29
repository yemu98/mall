package com.yemu.mallportal.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.UserLog;
import com.yemu.mallportal.mapper.UserLogMapper;
import com.yemu.mallportal.service.UserLogService;
import com.yemu.mallportal.service.UserUnlikeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/28
 */
@Service
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLog> implements UserLogService {
    private final UserUnlikeService userUnlikeService;

    public UserLogServiceImpl(UserUnlikeService userUnlikeService) {
        this.userUnlikeService = userUnlikeService;
    }

    @Override
    public void click(String token, int pid) {
        UserLog userLog = createUserLog(token,pid);
        if (null!=userLog) {
            userLog.setType("click");
            userLog.setLevel(1);
            baseMapper.insert(userLog);
            // 从不喜欢列表移除
            userUnlikeService.delete(userLog.getUid(),userLog.getPid());
        }

    }

    @Override
    public void addCart(String token, int pid) {
        UserLog userLog = createUserLog(token,pid);
        if (null != userLog) {
            userLog.setType("addCart");
            userLog.setLevel(2);
            baseMapper.insert(userLog);
        }
    }

    @Override
    public void disLike(String token, int pid) {
        UserLog userLog = createUserLog(token,pid);
        if (null!=userLog){
            userLog.setType("disLike");
            userLog.setLevel(-1);
            baseMapper.insert(userLog);
        }
    }

    @Override
    public void buy(String token, int pid) {
        UserLog userLog = createUserLog(token,pid);
        if (null != userLog) {
            userLog.setType("buy");
            userLog.setLevel(3);
            baseMapper.insert(userLog);
        }
    }

    @Override
    public List<UserLog> get(int num) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByUid(int uid, int num) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByPid(int pid, int num) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",pid);
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByUidWithPid(int uid, int pid) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid).eq("uid",uid);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public boolean isDislikeByUid(int uid, int pid) {
        return false;
    }

    UserLog createUserLog(String token, int pid) {
        UserLog userLog = null;
        int uid = TokenUtil.getUID(token);
        if (uid != 0) {
            userLog = new UserLog();
            userLog.setUid(uid);
            userLog.setPid(pid);
        }
        return userLog;
    }
}
