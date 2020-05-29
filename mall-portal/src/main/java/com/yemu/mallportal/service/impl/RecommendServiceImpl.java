package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mallportal.entity.ItemSimilarity;
import com.yemu.mallportal.entity.ManualRecommend;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.entity.UserLog;
import com.yemu.mallportal.mapper.ItemSimilarityMapper;
import com.yemu.mallportal.mapper.ManualRecommendMapper;
import com.yemu.mallportal.service.ProductService;
import com.yemu.mallportal.service.RecommendService;
import com.yemu.mallportal.service.UserLogService;
import com.yemu.mallportal.service.UserUnlikeService;
import com.yemu.mallportal.util.UserLogLevelEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    @Autowired
    private ManualRecommendMapper manualRecommendMapper;
    @Autowired
    private ItemSimilarityMapper itemSimilarityMapper;

    // 保存推荐结果 uid:productSet
    private static final Map<Integer, Set<Product>> recommend = new HashMap<>(16);

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
            productSet.addAll(byItemCf(userLog.getPid(), (pageSize/10)*3));
            productSet.addAll(bySearch(uid,(pageSize / 10) * 3));
            productSet.addAll(byCategory((pageSize / 10) * 2));
            productSet.addAll(byTag(userLog.getPid(), (pageSize / 10) * 1));
            productSet.addAll(byManual((pageSize / 10)));
        }

        // 如果推荐不足一页则随机抽取补足
        int count = 1;
        while (productSet.size() < pageSize) {
            // 最多补全3次，防止一直补全造成死循环
            if (count++ > 3) {
                break;
            }
            productSet.addAll(productService.random(pageSize - productSet.size()));
            // 过滤掉用户不喜欢的商品
            filterDisLike(productSet, uid);
            // 过滤已出现过的推荐
            filterRepeat(uid, productSet);
        }
        saveRecommend(uid,productSet,pageNo);
        return new ArrayList<>(productSet);
    }

    /**
     * 基于物品的内容过滤，根据物品相似度推荐
     */
    List<Product> byItemCf(int pid, int num) {
        List<Product> productList = new ArrayList<>();
        QueryWrapper<ItemSimilarity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid1", pid).orderByDesc("similarity").last("limit " + num);
        for (ItemSimilarity itemSimilarity : itemSimilarityMapper.selectList(queryWrapper)) {
            productList.add(productService.getById(itemSimilarity.getPid2()));
        }
        return productList;
    }

    /**
     * 根据人工设置的推荐
     */
    List<Product> byManual(int num) {
        List<Product> products = new ArrayList<>();
        QueryWrapper<ManualRecommend> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("level").last("limit " + num);
        for (ManualRecommend manualRecommend : manualRecommendMapper.selectList(queryWrapper)) {
            products.add(productService.getById(manualRecommend.getPid()));
        }
        return products;
    }

    /**
     * 根据标签的推荐
     */
    List<Product> byTag(int pid, int num) {
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
     * 根据用户搜索给出推荐
     * @param uid uid
     * @param num 数量
     * @return 推荐结果
     */

    List<Product> bySearch(int uid,int num){
        List<Product> products = new ArrayList<>();
        List<UserLog> userLogs = userLogService.getByUid(uid,num, UserLogLevelEnum.SEARCH.getLevel());
        for (UserLog userLog:userLogs){
            products.add(productService.getById(userLog.getPid()));
        }
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

    void filterRepeat(int uid, Set<Product> productSet) {
        // 移除已经推荐过的商品
        if (recommend.containsKey(uid) && recommend.get(uid).size() > 0) {
            Set<Product> productSet1 = recommend.get(uid);
            for (Product product : productSet1) {
                productSet.remove(product);
            }
        }
    }

    /**
     * 保存推荐历史
     * @param uid uid
     * @param productSet 推荐结果
     */
    void saveRecommend(int uid,Set<Product> productSet,int pageNo){
        // 页码数为1，清空推荐历史，重新生成推荐
        if (pageNo <= 1) {
            recommend.put(uid, productSet);
            return;
        }
        if (recommend.containsKey(uid)) {
            Set<Product> products = recommend.get(uid);
            products.addAll(productSet);
            recommend.put(uid, products);
        } else {
            recommend.put(uid, productSet);
        }
    }

    /**
     * 未登录推荐
     *
     * @param pageNo   页码
     * @param pageSize 每页数据量
     * @return 推荐结果
     */
    @Override
    public List<Product> commonRecommend(int pageNo, int pageSize) {
        return productService.page(new Page<>(pageNo, pageSize)).getRecords();
    }
}
