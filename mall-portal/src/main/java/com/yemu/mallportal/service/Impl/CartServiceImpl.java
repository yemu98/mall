package com.yemu.mallportal.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.Cart;
import com.yemu.mallportal.mapper.CartMapper;
import com.yemu.mallportal.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Override
    public Cart add(Cart cart) {
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",cart.getUid());
        wrapper.eq("pid",cart.getPid());
        List<Cart> carts = baseMapper.selectList(wrapper);
        if (carts.size()>0){
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("uid",cart.getUid());
            updateWrapper.eq("pid",cart.getPid());
            cart.setNum(carts.get(0).getNum()+1);
            baseMapper.update(cart,updateWrapper);
        }
        else{
            baseMapper.insert(cart);
        }
        return cart;
    }

    @Override
    public List<Cart> getCartByUid(int uid) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",uid);
        return baseMapper.selectList(queryWrapper);
    }
}
