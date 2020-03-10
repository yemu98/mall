package com.yemu.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@TableName(value = "user_click_history")
public class UserClickHistory {
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int uid;
    @NotNull(message = "pid 不能为空")
    private int pid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;//使用mybatis-plus后，用下划线命名会使变量为空
}
