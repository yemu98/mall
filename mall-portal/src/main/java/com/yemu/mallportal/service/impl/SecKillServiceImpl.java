package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.Order;
import com.yemu.mallportal.entity.SecKill;
import com.yemu.mallportal.mapper.SecKillMapper;
import com.yemu.mallportal.service.SecKillService;
import org.springframework.stereotype.Service;

@Service
public class SecKillServiceImpl extends ServiceImpl<SecKillMapper, SecKill> implements SecKillService {
    @Override
    public Order SecKill(Integer sku_id) {
        SecKill secKill = getBaseMapper().selectById(sku_id);
        secKill.setNumber(secKill.getNumber()-1);
        getBaseMapper().updateById(secKill);
        return null;
    }
}
