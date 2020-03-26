package com.yemu.mallportal.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yemu.mallportal.Exception.OrderException;
import com.yemu.mallportal.common.R;
import com.yemu.mallportal.common.TokenUtil;
import com.yemu.mallportal.entity.*;
import com.yemu.mallportal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 97674
 * @date 2020/3/18
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    ProductService productService;

    /**
     * 创建订单
     * @param token
     * @param cartItemIdList
     * @param addressId
     * @param payWay
     * @param remarks
     * @return
     */
    @PostMapping("")
    public R<?> create(@RequestHeader String token,
                       int[] cartItemIdList, int addressId,
                       @DefaultValue("online") String payWay,
                       @DefaultValue("") String remarks) throws Exception {
        Address address = addressService.getById(addressId);
        User user = userService.getById(TokenUtil.getUID(token));
        List<Order> orderList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int cartItemId:cartItemIdList){
            Order order = orderService.createOrder(cartService.getById(cartItemId),address,user,payWay,remarks);
            if (order==null){
                stringBuilder.append(productService.getById(cartService.getById(cartItemId).getPid()).getName()).append("库存不足");
            }
            orderList.add(order);
        }
        return R.ok(stringBuilder.toString(),orderList);
    }
    /**
     * 提交一个订单
     */
    @PostMapping("/new")
    public R<?> newOrder(@RequestHeader String token,
                         int cartItemId, int addressId,
                         @DefaultValue("online") String payWay,
                         @DefaultValue("") String remarks){
        Address address = addressService.getById(addressId);
        User user = userService.getById(TokenUtil.getUID(token));
        try{
            Order order = orderService.createOrder(cartService.getById(cartItemId),address,user,payWay,remarks);
            return R.ok("成功提交订单",order);
        } catch (Exception e){
            // 未能生成订单时的处理
            // 若是可预期的错误
            if (e instanceof OrderException){
                return R.error(((OrderException) e).getStatus(),e.getMessage());
            }
            else{
                // 非预期错误
            return R.error(500,"服务器内部错误");
            }

        }

    }
}
