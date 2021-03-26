package com.yemu.mallportal.controller;

import com.yemu.mall.common.R;
import com.yemu.mall.common.Response;
import com.yemu.mallportal.entity.User;
import com.yemu.mallportal.service.SecKillService;
import com.yemu.mallportal.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/seckill")
public class SecKillController {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SecKillService secKillService;

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

    /**
     *
     * @return
     */
    @GetMapping("/getTime")
    public R<?> getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND,5);
        return R.ok(Long.valueOf(calendar.getTime().getTime()));
    }

    @GetMapping("/startTime")
    public R<?> getStartTime(){
        return R.ok("test");
    }

    @PostMapping("/secKill")
    public R<?> secKill(int secKillId){
        try{
            secKillService.SecKill(secKillId);
            return R.ok("ok");
        }catch (Exception e){
            return R.error(e.getMessage());
        }
    }


}
