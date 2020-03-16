package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Img {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int pid;
    private String url;
    private String name;
}
