package com.xiaobai.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaobai.service.DishFlavorService;
import com.xiaobai.service.DishService;
import com.xiaobai.util.R;
import com.xiaobai.vo.DishVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 14:55:08
 * @Version 1.0
 * @ClassName DishFlavor
 * @Description 类方法说明：
 */
@RestController
@RequestMapping("/dish")
public class DishController implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private DishService dishService;

    @PostMapping
    public R<String> saveDish(@RequestBody DishVo dishVo) {
        dishService.saveDish(dishVo);
        return R.success("新增菜品成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        return dishService.getPage(page, pageSize, name);
    }

    @GetMapping("/{id}")
    public R<DishVo> getDishInfo(@PathVariable Long id) {
        return dishService.getDishInfo(id);
    }

    @PutMapping
    public R<String> update(@RequestBody DishVo dishVo) {
        dishService.updateWithFlavor(dishVo);
        return R.success("新增菜品成功");
    }
}
