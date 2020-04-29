package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.entity.UserLog;
import com.yemu.mallportal.service.ProductService;
import com.yemu.mallportal.service.RecommendService;
import com.yemu.mallportal.service.UserLogService;
import com.yemu.mallportal.service.UserUnlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yemuc
 * @date 2020/4/28
 */
@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserLogService userLogService;
    @Autowired
    private UserUnlikeService userUnlikeService;

    /**
     * 根据用户推荐
     *
     * @param uid 用户id
     * @return 推荐结果
     */
    @Override
    public List<Product> recommend(int uid, int pageNo, int pageSize) {
        Set<Product> productSet = new HashSet<>();
        List<UserLog> userLogs = userLogService.getByUid(uid, 10);
        // 针对用户最近的行为给出推荐
        for (UserLog userLog : userLogs) {
            // 推荐策略
            productSet.addAll(byItemCf(userLog.getPid(), (pageSize/10)*5));
            productSet.addAll(byCategory((pageSize/10)*2));
            productSet.addAll(byTag((pageSize/10)*10));
            productSet.addAll(byManual((pageSize / 10)));
        }

        // 如果推荐不足一页则随机抽取补足
        while (productSet.size() < pageSize) {
            productSet.addAll(productService.random(pageSize - productSet.size()));
            // 过滤掉用户不喜欢的商品
            filterDisLike(productSet, uid);
        }

        return new ArrayList<>(productSet);
    }

    /**
     * 基于物品的内容过滤，根据物品相似度推荐
     */
    List<Product> byItemCf(int pid, int num) {
        List<Product> productList = new ArrayList<>();

        return productList;
    }

    /**
     * 根据人工设置的推荐
     */
    List<Product> byManual(int num) {
        List<Product> products = new ArrayList<>();

        return products;
    }

    /**
     * 根据标签的推荐
     */
    List<Product> byTag(int num) {
        List<Product> products = new ArrayList<>();

        return products;
    }

    /**
     * 根据类别的推荐
     *
     * @return
     */
    List<Product> byCategory(int num) {
        List<Product> products = new ArrayList<>();

        return products;
    }

    /**
     * 过滤用户不感兴趣商品
     *
     * @param productSet 商品set
     */
    void filterDisLike(Set<Product> productSet, int uid) {
        productSet.removeIf(product -> userUnlikeService.contains(uid, product.getId()));
    }

    /**
     * 去除重复推荐
     */

    void filterRepeat(Set<Product> productSet, int pageNo) {

    }

    /**
     * 未登录推荐
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<Product> commonRecommend(int pageNo, int pageSize) {
        return productService.page(new Page<>(pageNo, pageSize)).getRecords();
    }
}
