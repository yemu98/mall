package com.yemu.malladmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@TableName(value = "img")
public class Img {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int pid;
    private String url;
    private String name;
}
