package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Img;

import java.util.List;

public interface ImgService extends IService<Img> {
    List<Img> getMain(int pid);
    List<Img> getDetail(int pid);
}
