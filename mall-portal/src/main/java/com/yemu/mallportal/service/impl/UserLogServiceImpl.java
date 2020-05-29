package com.yemu.mallportal.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.entity.UserLog;
import com.yemu.mallportal.mapper.UserLogMapper;
import com.yemu.mallportal.service.UserLogService;
import com.yemu.mallportal.service.UserUnlikeService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author yemuc
 * @date 2020/4/28
 * 异步日志收集
 */
@Service
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLog> implements UserLogService{
    private final UserUnlikeService userUnlikeService;

    public UserLogServiceImpl(UserUnlikeService userUnlikeService) {
        this.userUnlikeService = userUnlikeService;
    }

    @Override
    @Async
    public Future<Boolean> click(String token, int pid) {
        try {
            UserLog userLog = createUserLog(token,pid);
            if (null!=userLog) {
                userLog.setType("click");
                userLog.setLevel(1);
                baseMapper.insert(userLog);
                // 从不喜欢列表移除
                userUnlikeService.delete(userLog.getUid(),userLog.getPid());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Async
    public void addCart(String token, int pid) {
        UserLog userLog = createUserLog(token,pid);
        if (null != userLog) {
            userLog.setType("addCart");
            userLog.setLevel(2);
            baseMapper.insert(userLog);
        }
    }

    @Override
    @Async
    public void disLike(String token, int pid) {
        UserLog userLog = createUserLog(token,pid);
        if (null!=userLog){
            userLog.setType("disLike");
            userLog.setLevel(-1);
            baseMapper.insert(userLog);
        }
    }

    @Override
    @Async
    public void buy(String token, int pid) {
        UserLog userLog = createUserLog(token,pid);
        if (null != userLog) {
            userLog.setType("buy");
            userLog.setLevel(3);
            baseMapper.insert(userLog);
        }
    }

    @Override
    @Async
    public Future<Boolean> search(String token, List<Product> products) {
        // 只取10条
        if (products.size()>10){
            products = products.subList(0,10);
        }
        for (Product product:products){
            UserLog userLog = createUserLog(token,product.getId());
            if (null!=userLog){
                userLog.setType("search");
                userLog.setLevel(2);
                baseMapper.insert(userLog);
            }
        }
        return null;
    }

    @Override
    public List<UserLog> get(int num) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByUid(int uid, int num) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid).orderByDesc("id");
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByUid(int uid, int num, int level) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid).eq("level",level).orderByDesc("id");
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByPid(int pid, int num) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",pid).orderByDesc("id");
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByPid(int pid, int num, int level) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",pid).eq("level",level).orderByDesc("id");
        if (num!=0){
            queryWrapper.last("limit "+num);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByUidWithPid(int uid, int pid) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid).eq("uid",uid).orderByDesc("id");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserLog> getByUidWithPid(int uid, int pid, int level) {
        QueryWrapper<UserLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid).eq("pid",pid).eq("level",level).orderByDesc("id");
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
