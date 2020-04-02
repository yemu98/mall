package com.yemu.malladmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author yemuc
 * @date 2020/3/23
 */
@Data
@TableName("address")
public class Address {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int uid;
    private String name;
    private String address;
    private String phone;
    private boolean status = true;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;

}
