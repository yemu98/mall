package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yemuc
 * @date 2020/3/31
 */
@Data
@Accessors(chain = true)
public class Review {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private int uid;
    private int pid;
    private int grade=5;
    private String content;
    @TableField("order_number")
    private String orderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;
}
