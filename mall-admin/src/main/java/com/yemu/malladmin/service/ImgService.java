package com.yemu.malladmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.malladmin.entity.Img;

import java.util.List;

public interface ImgService extends IService<Img> {
    List<Img> getByPid(int pid);
}
