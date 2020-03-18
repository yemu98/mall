package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yemu.mallportal.common.R;
import com.yemu.mallportal.common.TokenUtil;
import com.yemu.mallportal.entity.CartItem;
import com.yemu.mallportal.model.CartItemModel;
import com.yemu.mallportal.model.CartModel;
import com.yemu.mallportal.service.CartService;
import com.yemu.mallportal.service.ImgService;
import com.yemu.mallportal.service.ProductService;
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
    private final CartService cartService;
    private final ProductService productService;
    private final ImgService imgService;

    public CartController(CartService cartService, ProductService productService, ImgService imgService) {
        this.cartService = cartService;
        this.productService = productService;
        this.imgService = imgService;
    }

    /**
     * 向购物车添加
     */
    @PostMapping("")
    public R<?> add(@RequestHeader(required = false) String token, CartItem cartItem){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        cartItem.setUid(uid);
        return cartService.add(cartItem)!=null?R.ok("加入购物车成功！",cartItem):R.error("加入购物车失败!");

    }
    /**
     * 查询购物车内容
     */

    @GetMapping("")
    public R<?> get(@RequestHeader(required = false) String token){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        List<CartItem> cartItemList = cartService.getCartByUid(uid);
        List<Map<String,?>> cart = new ArrayList<>();
        for (CartItem cartItem : cartItemList){
            Map<String,Object> item = new HashMap<>(16);
            item.put("product",productService.getById(cartItem.getPid()));
            item.put("imgList",imgService.getMain(cartItem.getPid()));
            item.put("num",cartItem.getNum());
            item.put("cartItemId",cartItem.getId());
            cart.add(item);
        }
        return R.ok(cart);
    }
    /**
     * 局部更新购物车
     */
    @PatchMapping("/{id}")
    public R<?> update(@RequestHeader(required = false) String token,
                    @PathVariable("id") int id,int pid, int num){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        CartItem cartItem = new CartItem().setId(id).setUid(uid).setPid(pid).setNum(num);
        UpdateWrapper<CartItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("uid",uid).eq("pid",pid);
        cartService.getBaseMapper().update(cartItem,updateWrapper);
        return R.ok(cartItem);
    }
    /**
     * 清空购物车
     */
    @DeleteMapping("")
    public R<?> delete(@RequestHeader String token){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        UpdateWrapper<CartItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("uid",uid);
        return cartService.getBaseMapper().delete(updateWrapper)>0?R.ok("清空成功"):R.ok("清空失败");
    }
    /**
     * 从购物车删除某商品
     */
    @DeleteMapping("/{id}")
    public R<?> deleteProduct(@RequestHeader String token,@PathVariable("id") int id){
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        if (uid==0){
            return R.error("用户未登录！");
        }
        return cartService.getBaseMapper().deleteById(id)>0?R.ok("删除成功！"):R.error("删除失败！");
    }
}
