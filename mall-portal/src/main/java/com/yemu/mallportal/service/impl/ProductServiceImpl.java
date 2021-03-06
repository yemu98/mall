package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.mapper.ProductMapper;
import com.yemu.mallportal.service.ProductService;
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
     * @param uid uid
     * @return 商品
     */

    @Override
    public List<Product> getByUser(int uid,int pageNo,int pageSize) {
        return getBaseMapper().findByUid(uid,pageNo,pageSize);
    }

    @Override
    public List<Product> search(Product product) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", product.getName())
                .or()
                .like("info", product.getInfo())
                .or()
                .like("brand", product.getBrand());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<Product> getHot(int num) {
        if (num == 0) {
            num = 10;
        }
        return getBaseMapper().getHot(num);
    }

    @Override
    public List<Product> random(int num) {
        return baseMapper.random(num);
    }

}
