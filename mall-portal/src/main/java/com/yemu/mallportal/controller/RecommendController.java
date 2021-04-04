package com.yemu.mallportal.controller;

import com.yemu.mall.common.R;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.service.ProductService;
import com.yemu.mallportal.service.RecommendService;
import com.yemu.mallportal.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author yemuc
 * @date 2020/4/28
 * 推荐网关
 */
@RestController
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private ProductService productService;
    @Autowired
    private RecommendService recommendService;

    private static Map<Integer,Set<Product>> recommendMap = new HashMap<>();

    @GetMapping
    public R<?> recommend(@RequestHeader(required = false) String token,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                          @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo) {
        List<Product> products;
        int uid = 0;
        // 根据token判断用户
        if (TokenUtil.verifyToken(token)) {
            uid = TokenUtil.getUID(token);
            // 已登录，个性化推荐
            products = recommendService.recommend(TokenUtil.getUID(token), pageNo, pageSize);
        } else {
            // 未登录，非个性化推荐
            products = recommendService.commonRecommend(pageNo, pageSize);

        }
        Set<Product> productSet;
        if (recommendMap.containsKey(uid)){
             productSet = recommendMap.get(uid);
            productSet.addAll(products);

        }else {
            productSet = new HashSet<>(products);
        }
        recommendMap.put(uid,productSet);
        productSet = null;
        return R.ok(ProductUtil.getProductListWithImgList(products));
    }
}
