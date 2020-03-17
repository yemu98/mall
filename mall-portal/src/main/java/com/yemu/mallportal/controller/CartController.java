package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yemu.mallportal.common.R;
import com.yemu.mallportal.common.TokenUtil;
import com.yemu.mallportal.entity.Cart;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.service.CartService;
import com.yemu.mallportal.service.ImgService;
import com.yemu.mallportal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ImgService imgService;
    /**
     * 向购物车添加
     */
    @PostMapping("")
    public R add(@RequestHeader(required = false) String token, int pid){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        Cart cart = new Cart().setPid(pid).setUid(uid);
//        Cart cart = new Cart();
//        cart.setUid(uid).setPid(pid);
//        cart.setUid(uid);
//        cart.setPid(pid);
        cartService.add(cart);
        return  R.ok(cart);

    }
    /**
     * 查询购物车内容
     */

    @GetMapping("")
    public R get(@RequestHeader(required = false) String token){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        List<Cart> cartList = cartService.getCartByUid(uid);
        List<Map<String,Object>> productList = new ArrayList<>();
        for (Cart cart : cartList){
            Map<String,Object> productMap = new HashMap<>(16);
            productMap.put("product",productService.getById(cart.getPid()));
            productMap.put("imgList",imgService.getMain(cart.getPid()));
            productList.add(productMap);
        }
        Map<String,List<?>> map = new HashMap<>(16);
        map.put("cart",cartList);
        map.put("prodcutList",productList);
        return R.ok(map);
    }
    /**
     * 更新购物车
     */
    /// 报错 请求不到
    @PatchMapping("/{id}")
    public R update(@RequestHeader(required = false) String token,
                    @PathVariable("id") int id,int pid,int num){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        Cart cart = new Cart().setId(id).setUid(uid).setPid(pid).setNum(num);
        UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("uid",uid).eq("pid",pid);
        cartService.getBaseMapper().update(cart,updateWrapper);
        return get(token);
    }
    /**
     * 清空购物车
     */
}
