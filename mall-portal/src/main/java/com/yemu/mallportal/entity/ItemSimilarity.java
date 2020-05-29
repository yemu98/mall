package com.yemu.mallportal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author yemuc
 * @date 2020/5/7
 */
@Data
@TableName("item_similarity")
public class ItemSimilarity {
    @JsonFormat
    private int pid1;
    private int pid2;
    private double similarity;
}
