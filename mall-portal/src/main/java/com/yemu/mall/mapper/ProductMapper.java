package com.yemu.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mall.entity.Product;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    List<Product> findByUid(int uid);
}