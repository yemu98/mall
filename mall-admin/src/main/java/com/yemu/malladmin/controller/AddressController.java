package com.yemu.malladmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yemu.mall.common.R;
import com.yemu.mall.common.TokenUtil;
import com.yemu.malladmin.entity.Address;
import com.yemu.malladmin.service.AddressService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yemuc
 * @date 2020/3/23
 */
@RestController
@Validated
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    /**
     * 根据地址id获取详情
     */

    @GetMapping("/{id}")
    public R<?> get(@PathVariable("id")int id){
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Address address = addressService.getBaseMapper().selectOne(queryWrapper);
        Map<String,Address> map = new HashMap<>(16);
        map.put("address",address);
        return R.ok(map);
    }

}
