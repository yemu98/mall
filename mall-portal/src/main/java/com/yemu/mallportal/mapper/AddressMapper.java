package com.yemu.mallportal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yemu.mallportal.entity.Address;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/23
 */
public interface AddressMapper extends BaseMapper<Address> {
    List<Address> getByUser(int uid);
}
