package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yemuc
 * @date 2020/4/29
 */
@Data
@TableName("product_tag")
public class ProductTag {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int pid;
    private String tag;
}
