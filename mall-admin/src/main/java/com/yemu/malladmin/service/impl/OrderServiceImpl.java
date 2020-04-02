package com.yemu.malladmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.malladmin.entity.Order;
import com.yemu.malladmin.mapper.OrderMapper;
import com.yemu.malladmin.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/2
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Override
    public Page<Order> search(String content, Page<Order> page) {
        return baseMapper.search(content, page);
    }

    @Override
    public Order getByOrderNumber(String orderNumber) {
        return baseMapper.getByOrderNumber(orderNumber);
    }
}
