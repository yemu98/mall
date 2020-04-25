package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.Carousel;
import com.yemu.mallportal.mapper.CarouselMapper;
import com.yemu.mallportal.service.CarouselService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/25
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
    @Override
    public List<Carousel> getList() {
        QueryWrapper<Carousel> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }
}
