package com.yemu.malladmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.malladmin.entity.Product;
import com.yemu.malladmin.exception.ProductException;
import com.yemu.malladmin.mapper.ProductMapper;
import com.yemu.malladmin.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public Page<Product> search(Page<Product>  page,String content) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",content)
                .or()
                .like("info",content)
                .or()
                .like("brand",content);
        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int delete(int pid) {
        Product product = baseMapper.selectById(pid);
        if (null==product){
            throw new ProductException(404,"没找到此商品");
        }
        product.setStatus("false");
        return baseMapper.updateById(product);
    }

    /**
     * 上架
     * @param pid pid
     * @return 反馈
     */
    @Override
    public int pullOn(int pid) {
        Product product = baseMapper.selectById(pid);
        if (null==product){
            throw new ProductException(404,"没找到此商品");
        }
        product.setStatus("true");
        return baseMapper.updateById(product);
    }
}
