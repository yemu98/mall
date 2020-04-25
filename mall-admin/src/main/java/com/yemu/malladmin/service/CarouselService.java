package com.yemu.malladmin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.malladmin.entity.Carousel;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/25
 */
public interface CarouselService extends IService<Carousel> {
    List<Carousel> getList();
    Carousel getById(int id);
    Carousel add(Carousel carousel);
    boolean delete(int id);
    Carousel updateCarousel(Carousel carousel);
}
