package com.yemu.malladmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@TableName(value = "product")
public class Product {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String info;
    private String name;
    private String brand;
    private BigDecimal price;
    private String category;
    private String status;
    private int stock;
//    List<Img> imgList;
}
