package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yemuc
 * @date 2020/4/28
 */
@Data
@TableName("user_log")
public class UserLog {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int uid;
    private int pid;
    private String type;
    private int level;
}
