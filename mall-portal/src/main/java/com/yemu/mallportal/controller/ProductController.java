package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mallportal.common.Response;
import com.yemu.mallportal.common.TokenUtil;
import com.yemu.mallportal.entity.Img;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.service.ImgService;
import com.yemu.mallportal.service.Impl.ProductServiceImpl;
import com.yemu.mallportal.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yemu
 */
@RestController
@Validated
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ImgService imgService;

    public ProductController(ProductServiceImpl productService, ImgService imgService) {
        this.productService = productService;
        this.imgService = imgService;
    }

    /**
     * 获取所有商品
     *
     * @return 商品列表
     */
    @GetMapping("/get")
    public Response<?> get(@RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                           @RequestParam(value = "pageNo",required = false,defaultValue = "1") int pageNo) {
        IPage<Product> iPage = new Page<>(pageNo,pageSize);
        List<Product> productList = productService.page(iPage).getRecords();
//        List<Product> productList = productService.getProductList();
        Map<String, Object> map = new HashMap<>(16);
        map.put("productList", getProductListWithImgList(productList));
        return Response.ok(map);
    }


    /**
     * 获取该商品的描述图片集合
     * @param product 商品
     * @return 图片列表
     */
    private List<Img> getImgListByProduct(Product product) {
        return imgService.getByPid(product.getId());
    }

    /**
     * 根据商品集合返回带有商品图片的集合
     *
     * @param productList 商品列表
     * @return 带有商品图片的商品列表
     */
    public List<Map<String, Object>> getProductListWithImgList(List<Product> productList) {

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

    /**
     * 根据用户过滤商品
     * @param token 用户token
     * @return 商品列表
     */
    @GetMapping(value = "/getByUser")
    public Response<?> getByUser(@RequestHeader(required = false) String token,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                 @RequestParam(value = "pageNo",required = false,defaultValue = "1") int pageNo) {
        int uid = (token == null || token.isEmpty()) ? 0 : TokenUtil.getUID(token);
        IPage<Product> iPage = new Page<>(pageNo,pageSize);

       List<Product> productList = productService.page(iPage).getRecords();
//        List<Product> productList = productService.getByUser(uid,pageNo,pageSize);
        iPage.setRecords(productList);
//        HashMap指定集合初始值为16
        Map<String, Object> map = new HashMap<>(16);
        map.put("productList", getProductListWithImgList(productList));
        return Response.ok(map);
    }

    /**
     * 搜索，搜索内容可以是商品名，品牌，描述
     *
     * @param searchContent 搜索内容
     * @return 搜索结果
     */
    @GetMapping("/search")
    public Response<?> search(String searchContent) {
        Product product = new Product();
        product.setName(searchContent);
        product.setBrand(searchContent);
        product.setInfo(searchContent);
        List<Product> productList = productService.search(product);
        Map<String, Object> map = new HashMap<>(16);
        map.put("productList", getProductListWithImgList(productList));
        return Response.ok(map);
    }

    /**
     * 获取5条热销的商品
     */
    @GetMapping("/hot/{num}")
    public Response<?> getHot(@PathVariable("num") int num){
        System.out.println(num);
        return get(10,1);
    }
}
