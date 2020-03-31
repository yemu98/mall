package com.yemu.mallportal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mallportal.entity.Review;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/31
 */
public interface ReviewMapper extends BaseMapper<Review> {
    List<Review> getByPid(int pid, Page<Review> page);
}
