package com.yemu.malladmin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.malladmin.entity.Order;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/2
 */
public interface OrderService extends IService<Order> {
    Page<Order> search(String content, Page<Order> page);
    Order getByOrderNumber(String orderNumber);
}
