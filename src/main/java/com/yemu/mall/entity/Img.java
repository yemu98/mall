package com.yemu.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Img {
    @JsonFormat
    private int id;
    private int pid;
    private String path;
}
