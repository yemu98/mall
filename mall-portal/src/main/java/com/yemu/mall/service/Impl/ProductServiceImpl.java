package com.yemu.mall.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.entity.Product;
import com.yemu.mall.mapper.ProductMapper;
import com.yemu.mall.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    public ArrayList<Product> getProductList() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        return (ArrayList<Product>) baseMapper.selectList(queryWrapper);
    }

    /**
     * 根据uid过滤获取商品集合
     *
     * @param uid
     * @return
     */

    @Override
    public List<Product> getByUser(int uid) {
        return getBaseMapper().findByUid(uid);
    }

    @Override
    public List<Product> search(Product product) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper();
        queryWrapper.like("name", product.getName())
                .or()
                .like("info", product.getInfo())
                .or()
                .like("brand", product.getBrand());
        return baseMapper.selectList(queryWrapper);
    }
}
