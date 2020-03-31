package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.Exception.ReviewException;
import com.yemu.mallportal.entity.Order;
import com.yemu.mallportal.entity.OrderStatus;
import com.yemu.mallportal.entity.Review;
import com.yemu.mallportal.mapper.ReviewMapper;
import com.yemu.mallportal.service.OrderService;
import com.yemu.mallportal.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/31
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {
    @Autowired
    private OrderService orderService;
    @Override
    public Review createReview(Review review) {
            Order order = orderService.getByOrderNumber(review.getOrderNumber());
            if (order==null){
                throw new ReviewException(404,"没有找到此订单");
            }
            if (order.getStatus()!= OrderStatus.待评价.getStatusCode()){
                throw new ReviewException(400,"现在不能评价此订单");
            }
            if (order.getUid()!=review.getUid()){
                throw new ReviewException(500,"您不能评价此订单");
            }
            if (review.getPid()==0){
                review.setPid(order.getPid());
            }
            try{
                getBaseMapper().insert(review);
                // 更新订单状态
                order.setStatus(4);
                orderService.updateById(order);
                return review;
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
    }

    @Override
    public List<Review> getByPid(int pid, Page<Review> page) {
        return baseMapper.getByPid(pid,page);
    }
}
