package com.yemu.malladmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yemu.malladmin.entity.Address;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/23
 */
public interface AddressService extends IService<Address> {
    List<Address> getByUser(int uid);

}
