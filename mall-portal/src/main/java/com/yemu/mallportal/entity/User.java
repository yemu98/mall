package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@TableName("user")
public class User {
    @JsonFormat
    @TableId(value = "id")
    private Integer id;
    private String name;
    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "密码不能为空")
    private String pwd;
    private String role;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;//使用mybatis-plus后，用下划线命名会使变量为空
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private String updateTime;//原因：mybatis用下划线代表大写，查询出来的字段如果带下划线，会自动转换为大写_a=A
}
