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
// 实体类与表名不一致
@TableName(value = "order_main")
public class Order {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
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
