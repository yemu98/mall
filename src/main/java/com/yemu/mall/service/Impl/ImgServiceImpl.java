package com.yemu.mall.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mall.entity.Img;
import com.yemu.mall.mapper.ImgMapper;
import com.yemu.mall.service.ImgService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl extends ServiceImpl<ImgMapper, Img> implements ImgService {
    @Override
    public List<Img> getById(int pid) {
        return baseMapper.getByPid(pid);
    }
}
