package com.yemu.mallportal.model;

import com.yemu.mallportal.entity.Img;
import com.yemu.mallportal.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * 商品详情
 * 包括商品信息
 * 商品主图
 * 商品描述图
 */
@Data
public class Item {
    private Product product;
    private List<Img> imgList;
    private List<Img> detailImgList;
}
