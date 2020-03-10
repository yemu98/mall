package com.yemu.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yemu.mall.common.Response;
import com.yemu.mall.entity.UserUnlike;
import com.yemu.mall.service.UserUnlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/unlike")
public class UserUnlikeController {
    @Autowired
    private UserUnlikeService userUnlikeService;

    @PostMapping("/add")
    public Response<?> addUnlike(@Valid UserUnlike userUnlike){
        try{

            userUnlikeService.getBaseMapper().insert(userUnlike);
            return Response.ok(userUnlike);
        }
        catch (Exception e){
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public Response<?> deleteUnlike(int pid){
        try{
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("pid",pid);
            userUnlikeService.getBaseMapper().delete(wrapper);
            return Response.ok();
        }
        catch (Exception e){
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }
}
