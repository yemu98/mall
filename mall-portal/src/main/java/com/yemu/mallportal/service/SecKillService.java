package com.yemu.mallportal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.mallportal.entity.Order;
import com.yemu.mallportal.entity.SecKill;

public interface SecKillService extends IService<SecKill> {
    Order SecKill(Integer sku_id);
}
