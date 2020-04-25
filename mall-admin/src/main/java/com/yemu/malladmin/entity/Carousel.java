package com.yemu.malladmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author yemuc
 * @date 2020/4/25
 * 轮播图
 */
@Data
@TableName("carousel")
public class Carousel {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @NotNull(message = "link不能为空")
    private String link;
    @NotNull(message = "imgUrl不能为空")
    private String imgUrl;
    private String info;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;
}
