package com.yemu.mall.controller;

import com.yemu.mall.common.Response;
import com.yemu.mall.entity.UserClickHistory;
import com.yemu.mall.service.UserClickHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/history/click")
public class UserClickHistoryController {
    @Autowired
    private UserClickHistoryService userClickHistoryService;
    @PostMapping(value = "/add")
    public Response<?> addClickHistory(UserClickHistory userClickHistory){
        try{
            userClickHistoryService.getBaseMapper().insert(userClickHistory);
            return Response.ok(userClickHistory);
        }
        catch (Exception e){
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }
}
