package com.yemu.malladmin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.malladmin.entity.Product;
import com.yemu.malladmin.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductMGTServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductMGTService {

}
