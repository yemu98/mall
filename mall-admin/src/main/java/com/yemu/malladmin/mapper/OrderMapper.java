package com.yemu.malladmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.malladmin.entity.Order;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/25
 */
public interface OrderMapper extends BaseMapper<Order> {
//    List<Order> search(String content, Page<Order> page);
    Order getByOrderNumber(String orderNumber);
    Page<Order> search(String content,Page<Order> page);
}
