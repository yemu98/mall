package com.yemu.mallportal.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key, value);
    }
}
