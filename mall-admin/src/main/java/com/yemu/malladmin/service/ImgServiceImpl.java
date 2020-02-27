package com.yemu.malladmin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.malladmin.entity.Img;
import com.yemu.malladmin.mapper.ImgMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl extends ServiceImpl<ImgMapper, Img> implements ImgService {
    @Override
    public List<Img> getById(int pid) {
        return baseMapper.getByPid(pid);
    }
}
