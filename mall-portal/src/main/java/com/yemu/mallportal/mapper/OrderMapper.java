package com.yemu.mallportal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mallportal.entity.Order;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/25
 */
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> search(int uid,String content);
    Order getByOrderNumber(String orderNumber);
}
