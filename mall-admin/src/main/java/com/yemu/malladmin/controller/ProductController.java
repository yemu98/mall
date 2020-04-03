package com.yemu.malladmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemu.mall.common.R;
import com.yemu.malladmin.common.Response;
import com.yemu.malladmin.entity.Img;
import com.yemu.malladmin.entity.Product;
import com.yemu.malladmin.exception.ProductException;
import com.yemu.malladmin.service.ImgService;
import com.yemu.malladmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品管理
 *
 * @author yemu
 */
@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    @Autowired
    ProductService productService;
    @Resource
    ImgService imgService;

    /**
     * 添加商品
     */
    @PostMapping("/add")
    public Response addProduct(@RequestBody ProductWithImg productWithImg) {
        try {
            Product newProduct = productWithImg.product;
            productService.getBaseMapper().insert(newProduct);
            if (!productWithImg.imgList.isEmpty()) {
                for (Img img : productWithImg.imgList) {
                    img.setPid(newProduct.getId());
                    imgService.updateById(img);
                }
            }
            return Response.ok("ok", "product", productWithImg.product);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }

    /***
     * 获取商品列表
     */
    @GetMapping("")
    public R<?> get(@RequestParam(value = "search", required = false) String search,
                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                    @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo) {
        Page<Product> page = new Page<>(pageNo, pageSize);
        return R.ok(productService.search(page, null == search ? "" : search));
    }

    /**
     * 获取商品详情
     */
    @GetMapping("/{id}")
    public R<?> getDetail(@PathVariable(value = "id")int id){
        return R.ok(productService.getById(id));
    }

    /**
     *获取商品图片列表
     */
    @GetMapping("/{id}/img")
    public R<?> getImg(@PathVariable(value = "id")int id){
        return R.ok(imgService.getByPid(id));
    }


    /**
     * 删除商品(下架)，订单会用到不能真的删除
     */
    @DeleteMapping("/{id}")
    public R<?> delete(@PathVariable(value = "id") int id) {
        try {
            if (productService.delete(id) > 0) {
                return R.ok("下架成功");
            } else {
                return R.error(500,"下架失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ProductException) {
                return R.error(((ProductException) e).getStatus(), e.getMessage());
            }
            return R.error(e.getMessage());
        }
    }

    /**
     * 上架商品
     */
    @PatchMapping("/{id}/pullOn")
    public R<?> pullOn(@PathVariable(value = "id") int id){
        try {
            if (productService.pullOn(id) > 0) {
                return R.ok("上架成功");
            } else {
                return R.error(500,"上架失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ProductException) {
                return R.error(((ProductException) e).getStatus(), e.getMessage());
            }
            return R.error(e.getMessage());
        }
    }
    /**
     * 修改商品信息
     */
    @PutMapping("/{id}")
    public R<?> update(@PathVariable(value = "id")int id,@RequestBody Product product){
        productService.updateById(product);
        return R.ok(product);
    }



    static class ProductWithImg {
        private Product product;
        private List<Img> imgList;

        public void setProduct(Product product) {
            this.product = product;
        }

        public void setImgList(List<Img> imgList) {
            this.imgList = imgList;
        }
    }

}


