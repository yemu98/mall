package com.yemu.mallportal.controller;

import com.yemu.mall.common.R;
import com.yemu.mallportal.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yemuc
 * @date 2020/4/25
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @GetMapping()
    public R<?> get(){
        return R.ok(carouselService.getList());
    }
}
