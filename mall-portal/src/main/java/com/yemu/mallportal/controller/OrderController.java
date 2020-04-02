package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yemu.mallportal.Exception.OrderException;
import com.yemu.mall.common.R;
import com.yemu.mall.common.TokenUtil;
import com.yemu.mallportal.entity.Address;
import com.yemu.mallportal.entity.Order;
import com.yemu.mallportal.entity.User;
import com.yemu.mallportal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 97674
 * @date 2020/3/18
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    ProductService productService;

    /**
     * 创建订单
     * @param token token
     * @param cartItemIdList 购物车id列表
     * @param addressId 地址id
     * @param payWay 支付方式（默认online）
     * @param remarks 备注（默认空）
     * @return 生成的订单
     */
    @PostMapping("")
    public R<?> create(@RequestHeader String token,
                       int[] cartItemIdList, int addressId,
                       @DefaultValue("online") String payWay,
                       @DefaultValue("") String remarks) throws Exception {
        Address address = addressService.getById(addressId);
        User user = userService.getById(TokenUtil.getUID(token));
        List<Order> orderList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int cartItemId:cartItemIdList){
            Order order = orderService.createOrder(cartService.getById(cartItemId),address,user,payWay,remarks);
            if (order==null){
                stringBuilder.append(productService.getById(cartService.getById(cartItemId).getPid()).getName()).append("库存不足");
            }
            orderList.add(order);
        }
        return R.ok(stringBuilder.toString(),orderList);
    }
    /**
     * 提交一个订单
     */
    @PostMapping("/new")
    public R<?> newOrder(@RequestHeader String token,
                         int cartItemId, int addressId,
                         @DefaultValue("online") String payWay,
                         @DefaultValue("") String remarks){
        Address address = addressService.getById(addressId);
        User user = userService.getById(TokenUtil.getUID(token));
        try{
            Order order = orderService.createOrder(cartService.getById(cartItemId),address,user,payWay,remarks);
            return R.ok("成功提交订单",order);
        } catch (Exception e){
            // 未能生成订单时的处理
            // 若是可预期的错误
            if (e instanceof OrderException){
                return R.error(((OrderException) e).getStatus(),e.getMessage());
            }
            else{
                // 非预期错误
            return R.error(500,"服务器内部错误");
            }

        }
    }


    /**
     * 获取用户所有订单
     */
    @GetMapping("")
    public R<?> getAll(@RequestHeader String token, @RequestParam(required = false) Integer id){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        // 获取某个订单信息
        if (id!=null){
            return get(token,id);
        }
        try{
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uid",uid).ne("status",9).orderByDesc("create_time");
            List<Order> orderList = orderService.getBaseMapper().selectList(queryWrapper);
            return R.ok(orderList);
        }catch (Exception e){
            if (e instanceof OrderException){
                return R.error(((OrderException) e).getStatus(),e.getMessage());
            }
            else{
                return R.error("服务器内部错误");
            }
        }
    }

    /**
     * 获取订单详情
     */
    @GetMapping("/{id}")
    public R<?> get(@RequestHeader String token,@PathVariable("id") int id){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        try{
            Order order = orderService.getById(id);
            return order!=null?R.ok(order):R.error(404,"无此订单");
        }catch (Exception e){
            if (e instanceof OrderException){
                return R.error(((OrderException) e).getStatus(),e.getMessage());
            }
            else{
                return R.error("服务器内部错误");
            }
        }
    }


    /**
     * 搜索订单
     */
    @GetMapping("/search")
    public R<?> search(@RequestHeader String token,String content){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        return R.ok(orderService.search(uid,content));
    }


    /*********/
    /**以下和订单状态有关的操作先写简单的进行流程验证
     * 可以尝试采用状态机模式
     */
    /*********/

    /**
     * 付款（模拟）
     */
    @PutMapping("/{orderNumber}/pay")
    public R<?> pay(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(1);
        orderService.getBaseMapper().updateById(order);
        return R.ok("支付成功");
    }
    /**
     * 确认收货
     */
    @PutMapping("/{orderNumber}/confirmReceipt")
    public R<?> confirmReceipt(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(3);
        orderService.getBaseMapper().updateById(order);
        return R.ok("收货成功");
    }

    /**
     * 申请换货
     */
    @PutMapping("/{orderNumber}/applyExchange")
    public R<?> applyExchange(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(7);
        orderService.getBaseMapper().updateById(order);
        return R.ok("申请成功");
    }

    /**
     * 取消申请换货
     */
    @PutMapping("{orderNumber}/cancelApplyExchange")
    public R<?> cancelApplyExchange(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }

        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(2);
        orderService.getBaseMapper().updateById(order);
        return R.ok("取消成功");
    }
    /**
     * 申请退款
     */
    @PutMapping("/{orderNumber}/applyRefund")
    public R<?> applyRefund(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(6);
        orderService.getBaseMapper().updateById(order);
        return R.ok("申请成功");
    }

    /**
     * 取消申请退款
     */
    @PutMapping("{orderNumber}/cancelApplyRefund")
    public R<?> cancelApplyRefund(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(2);
        orderService.getBaseMapper().updateById(order);
        return R.ok("取消成功");
    }
    /**
     * 取消订单
     */
    @PutMapping("/{orderNumber}/cancel")
    public R<?> cancel(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(8);
        orderService.getBaseMapper().updateById(order);
        return R.ok("取消成功");
    }
    /**
     * 删除订单（改变订单状态）
     */
    @DeleteMapping("/{orderNumber}")
    public R<?> deleteOrder(@RequestHeader String token,@PathVariable("orderNumber") String orderNumber){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Order order = orderService.getByOrderNumber(orderNumber);
        order.setStatus(9);
        orderService.getBaseMapper().updateById(order);
        return R.ok("删除成功");
    }

/********状态更新代码结束**********/

}
