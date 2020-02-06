package com.yemu.mall.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.yemu.mall.Common.Response;
import com.yemu.mall.Service.ImgService;
import com.yemu.mall.Service.ProductService;
import com.yemu.mall.Service.ProductServiceImpl;
import com.yemu.mall.entity.Img;
import com.yemu.mall.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private ProductServiceImpl productService;
    @Autowired
    private ImgService imgService;
    @GetMapping("/get")
    public Response get (){
        List<Product> productList=productService.getById();
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        for (Product product:productList){
            List<Img> imgs=imgService.getById(product.getId());
            Map<String,Object> map=new HashMap<>();
            map.put("product",product);
            map.put("imgs",imgs);
            list.add(map);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("products",list);
        return Response.ok(map);
    }
}
