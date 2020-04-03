package com.yemu.malladmin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mall.common.R;
import com.yemu.malladmin.entity.Order;
import com.yemu.malladmin.entity.OrderStatus;
import com.yemu.malladmin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author yemuc
 * @date 2020/4/2
 */
@RestController
@Validated
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单列表
     */
    @GetMapping("")
    public R<?> get(@RequestParam(required = false)String orderNumber,@RequestParam(required = false)String productName,
                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                    @RequestParam(value = "pageNo",required = false,defaultValue = "1") int pageNo){
        Page<Order> page = new Page<>(pageNo,pageSize);
        if (null!=orderNumber&&!orderNumber.isEmpty()){
            return R.ok(orderService.getByOrderNumber(orderNumber));
        }
        if (null!=productName&&!productName.isEmpty()){
            return R.ok(orderService.search(productName,page));
        }

        return R.ok(orderService.search("",page));
    }

    @GetMapping("/count")
    public R<?> getCount(){
        return R.ok(orderService.count());
    }


    /**
     * 根据id获取订单内容
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public R<?> getById(@PathVariable("id") int id){
        return R.ok(orderService.getById(id));
    }


    /**
     * 发货
     */
    @PatchMapping("{orderNumber}/deliver")
    public R<?> deliver(@PathVariable("orderNumber") String orderNumber){
        Order order = orderService.getByOrderNumber(orderNumber);
        if (null==order){
            return R.error(400,"该订单不可进行此操作");
        }
        order.setStatus(OrderStatus.待收货.getStatusCode());
        orderService.getBaseMapper().updateById(order);
        return R.ok("发货成功",order);
    }

    /**
     * 同意退款
     */
    @PatchMapping("{orderNumber}/refund")
    public R<?> refund(@PathVariable("orderNumber") String orderNumber){
        Order order = orderService.getByOrderNumber(orderNumber);
        if (null==order){
            return R.error(404,"没有找到此订单");
        }
        order.setStatus(OrderStatus.交易关闭.getStatusCode());
        orderService.getBaseMapper().updateById(order);
        return R.ok("退款成功",order);
    }

    /**
     * 同意换货
     */
    @PatchMapping("{orderNumber}/exchange")
    public R<?> exchange(@PathVariable("orderNumber") String orderNumber){
        Order order = orderService.getByOrderNumber(orderNumber);
        if (null==order){
            return R.error(404,"没有找到此订单");
        }
        order.setStatus(OrderStatus.待收货.getStatusCode());
        orderService.getBaseMapper().updateById(order);
        return R.ok("已重新发货",order);
    }

    /**
     * 恢复订单
     */

}
