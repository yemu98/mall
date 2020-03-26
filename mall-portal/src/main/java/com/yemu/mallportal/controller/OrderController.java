package com.yemu.mallportal.controller;

import com.yemu.mallportal.common.R;
import com.yemu.mallportal.common.TokenUtil;
import com.yemu.mallportal.entity.*;
import com.yemu.mallportal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("")
    public R<?> create(@RequestHeader String token,
                       int cartItemId, int addressId,
                       @DefaultValue("online") String payWay,
                       @DefaultValue("") String remarks){

        CartItem cartItem = cartService.getById(cartItemId);
        // 商品库存减掉
        Product product = productService.getById(cartItem.getPid());
        if (product.getStock()>=cartItem.getNum()){
            // 库存足够
            product.setStock(product.getStock()-cartItem.getNum());
            // 更新库存
            productService.updateById(product);
            // 创建订单
            Address address = addressService.getById(addressId);
            User user = userService.getById(TokenUtil.getUID(token));
            Order order = orderService.createOrder(cartItem,address,user,payWay,remarks);
            orderService.getBaseMapper().insert(order);
            // 从购物车删除已经创建订单的项
            cartService.deleteCartItem(cartItem);
            return R.ok("创建订单成功",order);
        }
        else {
            // 库存不足
            return R.error(400,"库存不足");
        }

    }
}
