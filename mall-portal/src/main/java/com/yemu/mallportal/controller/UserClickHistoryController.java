package com.yemu.mallportal.controller;

import com.yemu.mall.common.Response;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.UserClickHistory;
import com.yemu.mallportal.service.UserClickHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/history/click")
public class UserClickHistoryController {
    @Autowired
    private UserClickHistoryService userClickHistoryService;

    /**
     * 根据token和pid拼装成用户点击行为对象
     * @param token
     * @param pid
     * @return
     */
    @PostMapping(value = "/add")
    public Response<?> addClickHistory(@RequestHeader(required = false) String token,
                                       @Valid int pid){
        try{
            int uid = TokenUtil.getUID(token);
            if (uid!=0){
                UserClickHistory userClickHistory = new UserClickHistory();
                userClickHistory.setUid(uid);
                userClickHistory.setPid(pid);
                userClickHistoryService.getBaseMapper().insert(userClickHistory);
                return Response.ok(userClickHistory);
            }
            return Response.error("用户未登录");
        }
        catch (Exception e){
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }
}
