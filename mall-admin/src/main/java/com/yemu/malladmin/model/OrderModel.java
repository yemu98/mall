package com.yemu.malladmin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yemu.malladmin.entity.Order;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author yemuc
 * @date 2020/4/2
 */
@Data
@Accessors(chain = true)
public class OrderModel {
    public OrderModel(Order order){
        this.id = order.getId();
        this.uid = order.getUid();
        this.pid = order.getPid();
        this.addressId = order.getAddressId();
        this.number = order.getNumber();
        this.total = order.getTotal();
        this.orderNumber = order.getOrderNumber();
        this.status = order.getStatus();
        this.remarks = order.getRemarks();
        this.payWay = order.getPayWay();
        this.createTime = order.getCreateTime();
        this.updateTime = order.getUpdateTime();
    }
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField("order_number")
    private String orderNumber;
    private int uid;
    private int pid;
    private Integer number=1;
    private BigDecimal total;
    @TableField("address_id")
    private int addressId;
    private int status;
    private String remarks;
    private String payWay;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;
}
