package com.yemu.malladmin.entity;

/**
 * @author yemuc
 * @date 2020/3/31
 */
public enum OrderStatus {
    // 这里采用中文变量 方便使用
    待支付(0, "待支付"),
    待发货(1, "待发货"),
    待收货(2, "待收货"),
    待评价(3, "待评价"),
    交易完成(4, "交易完成"),
    订单已取消(5, "订单取消"),
    退款中(6, "退款中"),
    换货中(7, "换货中"),
    交易关闭(8, "交易关闭"),
    订单已删除(9, "订单已删除");
    private final int statusCode;
    private final String desc;

    OrderStatus(int statusCode, String desc) {
        this.statusCode = statusCode;
        this.desc = desc;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getDesc() {
        return this.desc;
    }
}
