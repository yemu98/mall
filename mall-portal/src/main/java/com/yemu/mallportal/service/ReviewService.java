package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Review;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/31
 */
public interface ReviewService extends IService<Review> {
    Review createReview(Review review);
    List<Review> getByPid(int pid, Page<Review> page);

}
