package com.yemu.mall.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.Common.Response;
import com.yemu.mall.entity.User;
import com.yemu.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper,User> implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Response Login(User user) {
        User user1=userMapper.getUserByPhone(user.getPhone());
        if (user1!=null){
            if (user1.getPwd().equals(user.getPwd())){
                user1.setPwd("");
                return Response.ok("欢迎回来！",user1);
            }
            else {
                return Response.error("密码错误");
            }
        }
        else {
            return Response.error("无此用户！");
        }

    }
}
