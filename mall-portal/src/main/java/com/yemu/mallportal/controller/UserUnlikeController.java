package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yemu.mall.common.R;
import com.yemu.mall.common.Response;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.UserUnlike;
import com.yemu.mallportal.service.UserUnlikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unlike")
public class UserUnlikeController {
    private final UserUnlikeService userUnlikeService;

    public UserUnlikeController(UserUnlikeService userUnlikeService) {
        this.userUnlikeService = userUnlikeService;
    }

    @PostMapping("/{pid}")
    public R<?> unlike(@PathVariable(value = "pid") int pid, @RequestHeader(required = false) String token) {
        try {
            int uid = TokenUtil.getUID(token);
            if (uid != 0) {
                UserUnlike userUnlike = new UserUnlike();
                userUnlike.setUid(uid);
                userUnlike.setPid(pid);
                userUnlikeService.getBaseMapper().insert(userUnlike);
            }
            return R.ok("ok");
        }
        catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }

    @DeleteMapping("/delete")
    public Response<?> deleteUnlike(int pid){
        try{
            QueryWrapper<UserUnlike> wrapper = new QueryWrapper<>();
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
