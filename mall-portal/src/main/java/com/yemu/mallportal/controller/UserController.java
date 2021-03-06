package com.yemu.mallportal.controller;

import com.yemu.mall.common.Response;
import com.yemu.mallportal.service.UserService;
import com.yemu.mallportal.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yemu
 * @date
 */
@RestController//=@ResponseBody+@Controller
@RequestMapping("/user")
@Validated//参数验证
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "getUserByName")
    public Response<?> getUserByName(@NotBlank(message = "name不能为空") String userName){
        User user=userService.findUserByName(userName);
        return Response.ok(user);
    }

    @GetMapping("/getByPhone")
    public Response<?> getByPhone(@NotBlank(message = "参数缺失") String phone){
        User user=userService.findUserByPhone(phone);
        if (null!=user){
//            Map<String,User> map=new HashMap<>();
//            map.put("user",user);
            return Response.ok("ok","user",user);
        }
        else {
            return Response.error("无此用户！");
        }
    }

    @GetMapping("/existByPhone")
    public Response<?> existByPhone(@NotBlank(message = "参数缺失") String phone){
        Map<String, Boolean> map=new HashMap<>(16);
        map.put("exist",userService.existUserByPhone(phone));
        return Response.ok(map);
    }

    @GetMapping(value = "getById")
    public Response<?> getUserById(@NotBlank(message = "id不能为空") String id){
        return Response.ok(userService.getById(id));
    }
}
