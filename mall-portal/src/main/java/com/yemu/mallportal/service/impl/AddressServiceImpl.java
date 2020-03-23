package com.yemu.mallportal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemu.mallportal.entity.Address;
import com.yemu.mallportal.mapper.AddressMapper;
import com.yemu.mallportal.model.AddressModel;
import com.yemu.mallportal.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yemuc
 * @date 2020/3/23
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Override
    public List<Address> getByUser(int uid) {
        return getBaseMapper().getByUser(uid);
    }
}
