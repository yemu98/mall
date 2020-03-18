package com.yemu.mallportal.model;

import com.yemu.mallportal.entity.CartItem;
import lombok.Data;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/18
 */
@Data
public class CartModel {
   private List<CartItemModel> cartItemModels;
}
