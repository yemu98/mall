package com.yemu.mall.controller;

import com.yemu.mall.common.Response;
import com.yemu.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 获取商品详细信息
     *
     * @param id
     */
    @GetMapping(value = "/{id}")
    public Response<?> get(@PathVariable("id") Integer id) {
        return Response.ok(productService.getBaseMapper().selectById(id));
    }
}
