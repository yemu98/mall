package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Product;

import java.util.List;

public interface ProductService extends IService<Product> {
    List<Product> getByUser(int uid,int pageNo,int pageSize);
    List<Product> search(Product product);
    List<Product> getHot(int num);
    List<Product> random(int num);
}
