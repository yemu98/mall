package com.yemu.mallportal.model;

import com.yemu.mallportal.entity.Img;
import com.yemu.mallportal.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/18
 */
@Data
public class CartItemModel {
    private Product product;
    private Img img;
    private int num;
}
