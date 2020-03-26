package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Address;
import com.yemu.mallportal.entity.CartItem;
import com.yemu.mallportal.entity.Order;
import com.yemu.mallportal.entity.User;

/**
 * @author yemuc
 * @date 2020/3/25
 */
public interface OrderService extends IService<Order> {
    Order createOrder(CartItem cartItem, Address address,User user,String payWay,String remarks);
}
