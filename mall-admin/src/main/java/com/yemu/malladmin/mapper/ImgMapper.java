package com.yemu.malladmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.malladmin.entity.Img;

import java.util.List;

public interface ImgMapper extends BaseMapper<Img> {
    List<Img> getByPid(int pid);
}
