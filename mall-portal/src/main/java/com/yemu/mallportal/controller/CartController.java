package com.yemu.mallportal.controller;

import com.yemu.mallportal.common.R;
import com.yemu.mallportal.common.TokenUtil;
import com.yemu.mallportal.entity.Cart;
import com.yemu.mallportal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 向购物车添加
     */
    @PostMapping("")
    public R add(@RequestHeader(required = false) String token, int pid){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
//        Cart cart = new Cart().setPid(pid).setUid(uid);
        Cart cart = new Cart();
//        cart.setUid(uid).setPid(pid);
        cart.setUid(uid);
        cart.setPid(pid);
        cartService.getBaseMapper().insert(cart);
        return  R.ok(cart);

    }
}
