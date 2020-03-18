package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.CartItem;

import java.util.List;

public interface CartService extends IService<CartItem> {
    CartItem add(CartItem cartItem);
    List<CartItem> getCartByUid(int uid);
    boolean deleteProduct(CartItem cartItem);
}
