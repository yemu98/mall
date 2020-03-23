package com.yemu.mallportal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author yemuc
 * @date 2020/3/23
 * 面向前端的地址实体类
 */
@Data
public class AddressModel {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int uid;
    private String name;
    private String address;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;
}
