package com.yemu.mall.entity;

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
    private String title;
    private String name;
    private String brand;
    private BigDecimal price;
    private String category;
}
