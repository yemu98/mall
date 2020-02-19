package com.yemu.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@TableName(value = "user_unlike")
public class UserUnlike {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int uid;
    private int pid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;

}
