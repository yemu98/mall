package com.yemu.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mall.common.R;
import com.yemu.mall.common.Response;
import com.yemu.mall.entity.Product;
import com.yemu.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;

/**
 * 商品详情
 */
@RestController
@Validated
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ProductService productService;


    /**
     *获取商品
     */
    @GetMapping(value = "")
    public R<?> get(@RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                    @RequestParam(value = "pageNo",required = false,defaultValue = "1") int pageNo){

        IPage<Product> iPage = new Page<>(pageNo,pageSize);
        return R.ok(productService.page(iPage));
    }
    @GetMapping(value = "/all")
    public R<?> get(){

        return R.ok(productService.getBaseMapper().selectList(new QueryWrapper<>()));
    }
    /**
     * 获取商品详细信息
     *
     * @param id
     */
    @GetMapping(value = "/{id}")
    public R get(@PathVariable("id") Integer id) {
        Product product = productService.getById(id);
//      return ResponseEntity.badRequest().body(Response.ok(product));
        return null!=product ? R.ok(product): R.error(HttpStatus.NOT_FOUND,"无此商品");
    }
}
