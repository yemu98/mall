package com.yemu.mallportal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mallportal.entity.Product;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    List<Product> findByUid(int uid,int pageNo,int pageSize);
    List<Product> getHot(int num);
}
