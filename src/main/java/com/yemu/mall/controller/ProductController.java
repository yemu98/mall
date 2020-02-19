package com.yemu.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yemu.mall.common.Response;
import com.yemu.mall.entity.UserUnlike;
import com.yemu.mall.service.ImgService;
import com.yemu.mall.service.Impl.ProductServiceImpl;
import com.yemu.mall.entity.Img;
import com.yemu.mall.entity.Product;
import com.yemu.mall.service.UserUnlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private  ProductServiceImpl productService;
    @Autowired
    private ImgService imgService;
    @Autowired
    private UserUnlikeService userUnlikeService;


    @GetMapping("/get")
    public Response<?> get (){
        List<Product> productList=productService.getById();
        List<Map<String,Object>> list= new ArrayList<>();
        for (Product product:productList){
                List<Img> imgList=imgService.getById(product.getId());
                Map<String,Object> map=new HashMap<>();
                map.put("imgList",imgList);
                map.put("product",product);
                list.add(map);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("productList",list);
        return Response.ok(map);
    }
    @GetMapping(value = "/getByUser")
//    根据用户过滤商品
    public Response<?> getByUser(@RequestParam(required = false) Integer uid){
        List<Product> productList=productService.getById();
        List<Map<String,Object>> list= new ArrayList<>();
        for (Product product:productList){
            QueryWrapper wrapper = new QueryWrapper();
            if (uid!=null){
                wrapper.eq("pid",product.getId());
                wrapper.eq("uid",uid);
                int count = userUnlikeService.count(wrapper);if (count==0){// 表中不存在数据时才放入返回结果中
                    List<Img> imgList=imgService.getById(product.getId());
                    Map<String,Object> map=new HashMap<>();
                    map.put("imgList",imgList);
                    map.put("product",product);
                    list.add(map);
                }
            }
            else {
                List<Img> imgList=imgService.getById(product.getId());
                Map<String,Object> map=new HashMap<>();
                map.put("imgList",imgList);
                map.put("product",product);
                list.add(map);
            }


        }
        Map<String,Object> map=new HashMap<>();
        map.put("productList",list);
        return Response.ok(map);
    }
}
