package com.yemu.malladmin.controller;

import com.yemu.mall.common.R;
import com.yemu.malladmin.entity.Carousel;
import com.yemu.malladmin.service.CarouselService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author yemuc
 * @date 2020/4/25
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    private final CarouselService carouselService;

    public CarouselController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    /**
     * 获取轮播图列表
     *
     * @param id required=false,获取详情
     * @return 轮播图列表
     */
    @GetMapping()
    public R<?> get(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        if (id != 0) {
            return getById(id);
        }
        return R.ok(carouselService.getList());
    }

    /**
     * 获取轮播图详情
     *
     * @param id id
     * @return 轮播图详情
     */
    @GetMapping("/{id}")
    public R<?> getById(@PathVariable(value = "id") int id) {
        return R.ok(carouselService.getById(id));
    }


    /**
     * 添加轮播图
     *
     * @param carousel 轮播图
     * @return 添加反馈
     */
    @PostMapping()
    public R<?> add(@RequestBody Carousel carousel) {
        try {
            carouselService.add(carousel);
            return R.ok(carousel);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     * 删除轮播图
     *
     * @param id id
     * @return 反馈
     */
    @DeleteMapping("/{id}")
    public R<?> delete(@PathVariable(value = "id") int id) {
        try {
            if (carouselService.delete(id)) {
                return R.ok("删除成功！");
            }else {
                return R.error("内部错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     * 删除?id=xx
     * @param id id
     * @return 反馈
     */
    @DeleteMapping()
    public R<?> delete2(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        if (id != 0) {
            return delete(id);
        } else {
            return R.error(HttpStatus.NOT_FOUND, "没有找到");
        }
    }

    /**
     * 更新
     * @param carousel 轮播图
     * @return 反馈
     */
    @PutMapping("/{id}")
    public R<?> update(Carousel carousel) {
        try {
            if (null!=carouselService.updateCarousel(carousel)){
                return R.ok(carousel);
            }else {
                return R.error("内部错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }


}
