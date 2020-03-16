package com.yemu.mallportal.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.Cart;
import com.yemu.mallportal.mapper.CartMapper;
import com.yemu.mallportal.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
}
