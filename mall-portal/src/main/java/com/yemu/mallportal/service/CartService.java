package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {
    Cart add(Cart cart);
    List<Cart> getCartByUid(int uid);
}
