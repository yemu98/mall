package com.yemu.mallportal.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Carousel;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/25
 */
public interface CarouselService extends IService<Carousel> {
    List<Carousel> getList();
}
