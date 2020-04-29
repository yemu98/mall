package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.UserLog;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/28
 */
public interface UserLogService extends IService<UserLog> {
    // 统计点击事件
    void click(String token,int pid);
    // 统计加入购物车
    void addCart(String token,int pid);
    // 不感兴趣
    void disLike(String token,int pid);
    // 购买
    void buy(String token,int pid);
    // 获取行为列表,num条
    List<UserLog> get(int num);
    // 根据uid获取行为列表，num条
    List<UserLog> getByUid(int uid,int num);
    // 根据pid获取行为列表
    List<UserLog> getByPid(int pid,int num);
    // 更加uid和pid获取行为列表
    List<UserLog> getByUidWithPid(int uid,int pid);
    // 用户是否不喜欢某商品
    boolean isDislikeByUid(int uid,int pid);
}
