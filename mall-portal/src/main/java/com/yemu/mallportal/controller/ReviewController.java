package com.yemu.mallportal.controller;

import com.yemu.mallportal.Exception.ReviewException;
import com.yemu.mall.common.R;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.Review;
import com.yemu.mallportal.service.ReviewService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author yemuc
 * @date 2020/3/31
 */
@RestController
@Validated
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * 发布评价
     * @param token token
     * @param review 评价
     * @return 评价
     */
    @PostMapping("")
    public R<?> create(@RequestHeader String token, Review review) {
        int uid = TokenUtil.getUID(token);
        if (uid == 0) {
            return R.error("未登录");
        }
        review.setUid(uid);
        try {
            reviewService.createReview(review);
            return R.ok(review);
        } catch (Exception e) {
            if (e instanceof ReviewException) {
                return R.error(((ReviewException) e).getStatus(), e.getMessage());
            } else {
                return R.error("内部错误");
            }
        }
    }


}
