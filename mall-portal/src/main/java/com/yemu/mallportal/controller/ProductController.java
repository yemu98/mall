package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mall.common.R;
import com.yemu.mall.common.Response;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.entity.Review;
import com.yemu.mallportal.model.ReviewModel;
import com.yemu.mallportal.service.*;
import com.yemu.mallportal.service.impl.ProductServiceImpl;
import com.yemu.mallportal.util.ProductUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yemu
 * 此接口面向订单，购物车
 */
@RestController
@Validated
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ImgService imgService;
    private final ReviewService reviewService;
    private final UserService userService;
    private final UserLogService userLogService;

    public ProductController(ProductServiceImpl productService,
                             ImgService imgService,
                             ReviewService reviewService, UserService userService,
                             UserLogService userLogService) {
        this.productService = productService;
        this.imgService = imgService;
        this.reviewService = reviewService;
        this.userService = userService;
        this.userLogService = userLogService;
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
        Map<String, Object> map = new HashMap<>(16);
        map.put("productList", ProductUtil.getProductListWithImgList(productList));
        return Response.ok(map);
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
        map.put("productList", ProductUtil.getProductListWithImgList(productList));
        return Response.ok(map);
    }

    /**
     * 搜索，搜索内容可以是商品名，品牌，描述
     *
     * @param searchContent 搜索内容
     * @return 搜索结果
     */
    @GetMapping("/search")
    public Response<?> search(String searchContent, @RequestHeader(required = false) String token) {
        Product product = new Product();
        product.setName(searchContent);
        product.setBrand(searchContent);
        product.setInfo(searchContent);
        List<Product> productList = productService.search(product);
        Map<String, Object> map = new HashMap<>(16);
        map.put("productList", ProductUtil.getProductListWithImgList(productList));
// 数据收集，此处应该是异步操作
        userLogService.search(token, productList);
        return Response.ok(map);
    }

    /**
     * 获取搜索建议 从热销中获取
     * @return 建议
     */
    @GetMapping("/search/suggest")
    public R<?> suggest(){

        List<Map<String,String>> suggestions = new ArrayList<>();
        for (Product product:productService.getHot(5)){
            Map<String,String> suggestion = new HashMap<>(1);
            suggestion.put("value",product.getName());
            suggestions.add(suggestion);
        }
        return R.ok(suggestions);
    }
    /**
     * 获取num条热销的商品
     */
    @GetMapping("/hot")
    public R<?> getHot(@RequestParam(value = "num",required = false,defaultValue = "10") Integer num){

        return R.ok(ProductUtil.getProductListWithImgList(productService.getHot(num)));
    }
    @GetMapping(value = {"/hot/{num}"})
    public R<?> getHot2(@PathVariable(required = false) Integer num){
        if (num==null){
            num=10;
        }
        return R.ok(ProductUtil.getProductListWithImgList(productService.getHot(num)));
    }

    /**
     * 根据商品id查询
     */
    @GetMapping("/{pid}")
    public R<?> get(@PathVariable("pid") int pid,@RequestHeader(required = false)String token){
        Map<String,Object> map = new HashMap<>(16);
        map.put("product",productService.getById(pid));
        map.put("imgList",imgService.getMain(pid));
        return R.ok(map);
    }

    /**
     * 获取商品库存
     */
    @GetMapping("/{id}/stock")
    public R<?> getStock(@PathVariable("id") int id){
        int stock = productService.getById(id).getStock();
        return R.ok(stock);
    }

    /**
     * 获取商品评价
     * @param id 产品id
     * @param pageSize 页面大小
     * @param pageNo 页码
     * @return 评价
     */
    @GetMapping("/{id}/review")
    public R<?> getReview(@PathVariable("id") int id,
                          @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                          @RequestParam(value = "pageNo",required = false,defaultValue = "1") int pageNo){
        Page<Review> iPage = new Page<>(pageNo,pageSize);
        List<Review> reviews = reviewService.getByPid(id,iPage);
        List<ReviewModel> reviewModels = new ArrayList<>();
        for (Review review: reviews){
            reviewModels.add(new ReviewModel(review).setName(userService.getNameByUid(review.getUid())));
        }
        return R.ok(reviewModels);
    }
}
