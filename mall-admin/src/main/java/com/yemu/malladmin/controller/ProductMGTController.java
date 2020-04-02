package com.yemu.malladmin.controller;

import com.yemu.malladmin.common.Response;
import com.yemu.malladmin.service.ImgService;
import com.yemu.malladmin.service.ProductMGTService;
import com.yemu.malladmin.entity.Img;
import com.yemu.malladmin.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品管理
 * @author yemu
 */
@RestController
@RequestMapping("/product")
@Validated
public class ProductMGTController {

    @Autowired
    ProductMGTService productMGTService;
    @Resource
    ImgService imgService;
    /**
     * 添加商品
     */
    @PostMapping("/add")
    public Response addProduct(@RequestBody ProductWithImg productWithImg){
        try{
            Product newProduct = productWithImg.product;
                productMGTService.getBaseMapper().insert(newProduct);
            if (!productWithImg.imgList.isEmpty()){
                for (Img img : productWithImg.imgList ){
                    img.setPid(newProduct.getId());
                    imgService.updateById(img);
                }
            }
            return Response.ok("ok","product",productWithImg.product);
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
    }


    /**
     * 删除商品
     */


    /**
     * 修改商品信息
     */

    /**
     * 查询商品信息
     */


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


