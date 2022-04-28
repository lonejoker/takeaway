package com.xiaobai.controller;

import com.xiaobai.service.DishFlavorService;
import com.xiaobai.service.DishService;
import com.xiaobai.util.R;
import com.xiaobai.vo.DishVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
