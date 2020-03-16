package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@TableName(value = "user_unlike")
public class UserUnlike {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @NotNull(message = "uid not null")
    private int uid;
    @NotNull(message = "pid not null")
    private int pid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;

}
