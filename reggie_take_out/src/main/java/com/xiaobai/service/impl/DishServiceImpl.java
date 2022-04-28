package com.xiaobai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.entity.Dish;
import com.xiaobai.entity.DishFlavor;
import com.xiaobai.mapper.DishFlavorMapper;
import com.xiaobai.mapper.DishMapper;
import com.xiaobai.service.DishFlavorService;
import com.xiaobai.service.DishService;
import com.xiaobai.vo.DishVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 13:41:14
 * @Version 1.0
 * @ClassName Dish
 * @Description 类方法说明：
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;
    @Autowired
    private DishFlavorService dishFlavorService;

    @Transactional
    @Override
    public void saveDish(DishVo dishVo) {
        //保存菜品的基本信息到菜品表dish
        this.save(dishVo);

        Long dishId = dishVo.getId(); //菜品id

        //菜品口味
        List<DishFlavor> flavors = dishVo.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }
}
