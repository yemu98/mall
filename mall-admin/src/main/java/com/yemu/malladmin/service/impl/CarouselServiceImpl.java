package com.yemu.malladmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.malladmin.entity.Carousel;
import com.yemu.malladmin.exception.CarouselException;
import com.yemu.malladmin.mapper.CarouselMapper;
import com.yemu.malladmin.service.CarouselService;
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

    @Override
    public Carousel getById(int id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Carousel add(Carousel carousel) throws RuntimeException {
        baseMapper.insert(carousel);
        return carousel;
    }

    @Override
    public boolean delete(int id) {
        if (baseMapper.deleteById(id)>0){
            return true;
        }
        if (baseMapper.selectById(id)==null){
            throw new CarouselException(404,"没有找到此项");
        }
        return false;
    }

    @Override
    public Carousel updateCarousel(Carousel carousel) {
        if (baseMapper.updateById(carousel)>0){
            return carousel;
        }
        if (baseMapper.selectById(carousel.getId())==null){
            throw new CarouselException(404,"没有找到此项");
        }
        return null;
    }
}
