package com.yemu.mall.controller;

import com.yemu.mall.common.Response;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mall.entity.Img;
import com.yemu.mall.entity.Product;
import com.yemu.mall.service.ImgService;
import com.yemu.mall.service.Impl.ProductServiceImpl;
import com.yemu.mall.service.UserUnlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ImgService imgService;
    @Autowired
    private UserUnlikeService userUnlikeService;

    /**
     * 获取所有商品
     *
     * @return
     */
    @GetMapping("/get")
    public Response<?> get() {
        List<Product> productList = productService.getProductList();
        Map<String, Object> map = new HashMap<>();
        map.put("productList", getProductListWithImgList(productList));
        return Response.ok(map);
    }


    /**
     * 获取该商品的描述图片集合
     *
     * @param product
     * @return
     */
    public List<Img> getImgListByProduct(Product product) {
        return imgService.getByPid(product.getId());
    }

    /**
     * 根据商品集合返回带有商品图片的集合
     *
     * @param productList
     * @return
     */
    public List<Map<String, Object>> getProductListWithImgList(List<Product> productList) {

        List<Map<String, Object>> list = new ArrayList<>();
        // 遍历集合为每个商品添加图片集合
        for (Product product : productList) {
            Map<String, Object> map = new HashMap<>();
            map.put("imgList", getImgListByProduct(product));
            map.put("product", product);
            list.add(map);
        }
        return list;
    }

    @GetMapping(value = "/getByUser")
//    根据用户过滤商品
    public Response<?> getByUser(@RequestHeader(required = false) String token) {
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        List<Product> productList = productService.getByUser(uid);
        Map<String, Object> map = new HashMap<>();
        map.put("productList", getProductListWithImgList(productList));
        return Response.ok(map);
    }

    /**
     * 搜索，搜索内容可以是商品名，品牌，描述
     *
     * @param searchContent
     * @return
     */
    @GetMapping("/search")
    public Response<?> search(String searchContent) {
        Product product = new Product();
        product.setName(searchContent);
        product.setBrand(searchContent);
        product.setInfo(searchContent);
        List<Product> productList = productService.search(product);
        Map<String, Object> map = new HashMap<>();
        map.put("productList", getProductListWithImgList(productList));
        return Response.ok(map);
    }

    /**
     * 获取5条热销的商品
     */
}
