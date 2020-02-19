package com.yemu.mall.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.entity.Product;
import com.yemu.mall.mapper.ProductMapper;
import com.yemu.mall.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    public ArrayList<Product> getById(){
        QueryWrapper<Product> queryWrapper=new QueryWrapper<>();
        return (ArrayList<Product>) baseMapper.selectList(queryWrapper);
    }
}
