package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.CartItem;
import com.yemu.mallportal.mapper.CartItemMapper;
import com.yemu.mallportal.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartService {
    @Override
    public CartItem add(CartItem cartItem) {
        if (cartItem.getPid()==0|| cartItem.getUid()==0){
            return null;
        }
        try{
            QueryWrapper<CartItem> wrapper = new QueryWrapper<>();
            wrapper.eq("uid", cartItem.getUid());
            wrapper.eq("pid", cartItem.getPid());
            List<CartItem> cartItems = baseMapper.selectList(wrapper);
            if (cartItems.size()>0){
                UpdateWrapper<CartItem> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("uid", cartItem.getUid());
                updateWrapper.eq("pid", cartItem.getPid());
                cartItem.setNum(cartItems.get(0).getNum()+ cartItem.getNum());
                baseMapper.update(cartItem,updateWrapper);
            }
            else{
                baseMapper.insert(cartItem);
            }
            return cartItem;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CartItem> getCartByUid(int uid) {
        QueryWrapper<CartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public boolean deleteCartItem(CartItem cartItem) {
        UpdateWrapper<CartItem> deleteWrapper = new UpdateWrapper<>();
        deleteWrapper.eq("uid", cartItem.getUid()).eq("id",cartItem.getId());
        return baseMapper.delete(deleteWrapper) > 0;
    }
}
