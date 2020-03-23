package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yemuc
 * @date 2020/3/18
 */
@Data
@TableName(value = "order")
public class Order {
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
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;
}