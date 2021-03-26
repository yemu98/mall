package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("seckill")
public class SecKill {
    @JsonFormat
    @TableId("id")
    private Integer id;
    @TableField("sku_id")
    private int skuId;
    private String name;
    @TableField("start_time")
    private Timestamp startTime;
    @TableField("end_time")
    private Timestamp endTime;
    private int number;

    @TableField("create_time")
    private String createTime;//使用mybatis-plus后，用下划线命名会使变量为空
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;//原因：mybatis用下划线代表大写，查询出来的字段如果带下划线，会自动转换为大写_a=A
}
