package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("product")
public class Product {
    @JsonFormat
    @TableId(value = "id")
    private int id;
    private String info;
    private String name;
    private String brand;
    private BigDecimal price;
    private String category;
    private String status;
    private int stock;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;//使用mybatis-plus后，用下划线命名会使变量为空
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;//原因：mybatis用下划线代表大写，查询出来的字段如果带下划线，会自动转换为大写_a=A
}
