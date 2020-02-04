package com.yemu.mall.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.Common.Response;
import com.yemu.mall.Common.ResponseCode;
import com.yemu.mall.Common.TokenUtil;
import com.yemu.mall.entity.Token;
import com.yemu.mall.entity.User;
import com.yemu.mall.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
                String token=TokenUtil.createToken(user1.getId());
                return Response.ok("欢迎回来！", token);
            }
            else {
                return Response.error("密码错误");
            }
        }
        else {
            return Response.error("无此用户！");
        }

    }

    @Override
    public Response isLogin(String token) {
        if (null == token || token.isEmpty()){
            return Response.error(ResponseCode.UNLOGIN.getCode(),ResponseCode.UNLOGIN.getDesc());
        }
        if (TokenUtil.verifyToken(token)){
            return Response.ok();
        }
        else{
            return Response.error(ResponseCode.UNLOGIN.getCode(),ResponseCode.UNLOGIN.getDesc());
        }
    }
}
