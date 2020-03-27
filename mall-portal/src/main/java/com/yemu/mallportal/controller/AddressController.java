package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yemu.mallportal.common.R;
import com.yemu.mallportal.common.TokenUtil;
import com.yemu.mallportal.entity.Address;
import com.yemu.mallportal.service.AddressService;
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
     * 获取该用户所有地址
     * @param token token
     * @return 地址列表
     */
    @GetMapping("")
    public R<?> get(@RequestHeader String token) {
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Map<String, List<Address>> map = new HashMap<>(16);
        map.put("addressList",addressService.getByUser(uid));
        return R.ok(map);
    }

    /**
     * 根据地址id获取详情
     */

    @GetMapping("/{id}")
    public R<?> get(@RequestHeader String token, @PathVariable("id")int id){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        queryWrapper.eq("uid",uid);
        Address address = addressService.getBaseMapper().selectOne(queryWrapper);
        Map<String,Address> map = new HashMap<>(16);
        map.put("address",address);
        return R.ok(map);
    }

    /**
     * 添加地址
     */
    @PostMapping("")
    public R<?> add(@RequestHeader String token,Address address){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        address.setUid(uid);
       try{
           address.setStatus(true);
           addressService.getBaseMapper().insert(address);
           return R.ok("添加成功");
       }
       catch (Exception e){
           e.printStackTrace();
           return R.error(e.getMessage());
       }
    }

    /**
     * 根据地址id删除地址
     * 不能真的删除 因为订单可能要用到
     */
    @DeleteMapping("{id}")
    public R<?> delete(@RequestHeader String token, @PathVariable("id")int id){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        Address address = addressService.getById(id);
        if (address!=null){
            address.setStatus(false);
        }
        return update(token,id,address);
//        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("uid",uid);
//        queryWrapper.eq("id",id);
//        return addressService.getBaseMapper().delete(queryWrapper)>0?R.ok("删除成功"):R.error("删除失败");
    }


    /**
     * 更新地址
     */
    @PutMapping("{id}")
    public R<?> update(@RequestHeader String token, @PathVariable("id")int id,Address address){
        int uid = TokenUtil.getUID(token);
        if (uid==0){
            return R.error("未登录");
        }
        address.setUid(uid);
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        queryWrapper.eq("id",id);
        return addressService.getBaseMapper().update(address,queryWrapper)>0?R.ok("更新成功"):R.error("更新失败");
    }


}
