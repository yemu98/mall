package com.yemu.malladmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.malladmin.entity.Product;
import com.yemu.malladmin.mapper.ProductMapper;
import com.yemu.malladmin.service.ProductMGTService;
import org.springframework.stereotype.Service;

@Service
public class ProductMGTServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductMGTService {

}
