package com.yemu.mallportal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yemu.mallportal.entity.Review;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yemuc
 * @date 2020/4/1
 */
@Data
@Accessors(chain = true)
public class ReviewModel {

    public ReviewModel(Review review){
        this.id = review.getId();
        this.uid = review.getUid();
        this.pid = review.getPid();
        this.content = review.getContent();
        this.grade = review.getGrade();
        this.orderNumber = review.getOrderNumber();
        this.createTime = review.getCreateTime();
        this.updateTime = review.getUpdateTime();
    }
    @JsonFormat
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int uid;
    private String name;
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
