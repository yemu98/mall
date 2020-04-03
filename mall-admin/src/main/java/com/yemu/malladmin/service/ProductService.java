package com.yemu.malladmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.malladmin.entity.Product;

public interface ProductService extends IService<Product> {
    Page<Product> search(Page<Product> page,String content);
    int delete(int pid);
    int pullOn(int pid);
}
