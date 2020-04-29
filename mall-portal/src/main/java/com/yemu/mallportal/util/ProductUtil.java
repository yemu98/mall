package com.yemu.mallportal.util;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mallportal.entity.Img;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.service.ImgService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yemuc
 * @date 2020/4/28
 * 商品工具类
 * 用@Component注解，让spring管理此类
 *
 */
@Component
public class ProductUtil {

    private static ImgService imgService;

    /**
     * 使用构造器注入bean
     * @param imgService bean
     */
    public ProductUtil(ImgService imgService) {
        ProductUtil.imgService = imgService;
    }

    /**
     * 获取该商品的描述图片集合
     *
     * @param product 商品
     * @return 图片列表
     */
    static public List<Img> getImgListByProduct(Product product) {
        return imgService.getMain(product.getId());
    }

    /**
     * 根据商品集合返回带有商品图片的集合
     *
     * @param productList 商品列表
     * @return 带有商品图片的商品列表
     */
    static public List<Map<String, Object>> getProductListWithImgList(List<Product> productList) {

        List<Map<String, Object>> list = new ArrayList<>();
        // 遍历集合为每个商品添加图片集合
        for (Product product : productList) {
            Map<String, Object> map = new HashMap<>(16);
            map.put("imgList", getImgListByProduct(product));
            map.put("product", product);
            list.add(map);
        }
        return list;
    }
}
