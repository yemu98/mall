package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.*;
import com.yemu.mallportal.mapper.OrderMapper;
import com.yemu.mallportal.service.OrderService;
import com.yemu.mallportal.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yemuc
 * @date 2020/3/25
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    final ProductService productService;

    public OrderServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    /***
     * 创建订单
     * @param cartItem 购物车项
     * @param address 地址
     * @param payWay 支付方式
     * @param remarks 备注
     * @param user 用户
     * @return 创建的订单
     */
    @Override
    public Order createOrder(CartItem cartItem, Address address,User user, String payWay, String remarks) {
        Product product = productService.getById(cartItem.getPid());
        Order order = new Order();
        order.setUid(user.getId());
        order.setPid(product.getId());
        order.setNumber(cartItem.getNum());
        order.setTotal(product.getPrice().multiply(BigDecimal.valueOf(cartItem.getNum())));
        order.setAddressId(address.getId());
        order.setStatus("已创建订单");
        order.setRemarks(remarks);
        order.setPayWay(payWay);
        createOrderNumber(order);
        return order;
    }

    /**
     * 创建订单号 编号规则为时间戳（到毫秒）+用户id+商品id
     * @param order 订单
     */
    private void createOrderNumber(Order order){
        String orderNumber = String.valueOf(new Date().getTime()) +
                order.getUid() +
                order.getPid();
        order.setOrderNumber(orderNumber);
    }
}
