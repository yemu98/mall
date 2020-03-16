package com.yemu.mallportal.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mallportal.common.R;
import com.yemu.mallportal.entity.Img;
import com.yemu.mallportal.entity.Product;
import com.yemu.mallportal.model.Item;
import com.yemu.mallportal.service.ImgService;
import com.yemu.mallportal.service.Impl.ProductServiceImpl;
import com.yemu.mallportal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品详情
 */
@RestController
@Validated
@RequestMapping("/item")
public class ItemController {
    @Autowired
   private ProductService productService;
    @Autowired
    private  ImgService imgService;
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
        List<Img> imgList = imgService.getMain(product.getId());
        Item item = new Item();
        item.setProduct(product);
        item.setImgList(imgList);
        List<Img> deatilImgList = imgService.getDetail(product.getId());
        item.setDetailImgList(deatilImgList);
//      return ResponseEntity.badRequest().body(Response.ok(product));
        return null!=product ? R.ok(item): R.error(HttpStatus.NOT_FOUND,"无此商品");
    }
}
