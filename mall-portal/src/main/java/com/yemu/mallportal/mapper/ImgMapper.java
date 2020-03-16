package com.yemu.mallportal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mallportal.entity.Img;

import java.util.List;

public interface ImgMapper extends BaseMapper<Img> {
    List<Img> getByPid(int pid);
}
