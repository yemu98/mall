package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mallportal.entity.Product;

import java.util.List;
import java.util.Set;

/**
 * @author yemuc
 * @date 2020/4/28
 */
public interface RecommendService {
//    个性化推荐
    List<Product> recommend(int uid, int pageNo, int pageSize);
//    热销推荐
    List<Product> commonRecommend(int pageNo,int pageSize);
}
