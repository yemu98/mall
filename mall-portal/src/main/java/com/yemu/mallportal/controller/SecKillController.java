package com.yemu.mallportal.controller;

import com.yemu.mall.common.R;
import com.yemu.mall.common.Response;
import com.yemu.mallportal.entity.User;
import com.yemu.mallportal.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seckill")
public class SecKillController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/get")
    public Response<?> get(@RequestParam(value = "key") String key){
        return Response.ok(redisUtil.get(key));
    }

    @PostMapping("/set")
    public R<?> set(@RequestParam(value = "key")String key, User user){
        try{
            redisUtil.set(key,user);
            return R.ok("ok");
        }catch (Exception e){
            return R.error(e.getMessage());
        }
    }
}
