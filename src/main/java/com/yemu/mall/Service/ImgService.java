package com.yemu.mall.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.entity.Img;
import com.yemu.mall.mapper.ImgMapper;

import java.util.List;

public interface ImgService extends IService<Img> {
    List<Img> getById(int pid);
}
