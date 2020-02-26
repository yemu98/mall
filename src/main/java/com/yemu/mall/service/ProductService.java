package com.yemu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mall.entity.Product;

import java.util.List;

public interface ProductService extends IService<Product> {
    List<Product> getByUser(int uid);

    List<Product> search(Product product);
}
