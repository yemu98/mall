package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.yemu.mallportal.entity.Address;
import com.yemu.mallportal.entity.CartItem;
import com.yemu.mallportal.entity.Order;
import com.yemu.mallportal.entity.User;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/25
 */
public interface OrderService extends IService<Order> {
    Order createOrder(CartItem cartItem, Address address,User user,String payWay,String remarks) throws Exception;
    List<Order> search(int uid,String content);
    Order getByOrderNumber(String orderNumber);
}
