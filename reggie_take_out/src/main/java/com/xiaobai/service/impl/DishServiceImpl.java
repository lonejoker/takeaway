package com.xiaobai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.entity.Category;
import com.xiaobai.entity.Dish;
import com.xiaobai.entity.DishFlavor;
import com.xiaobai.mapper.CategoryMapper;
import com.xiaobai.mapper.DishFlavorMapper;
import com.xiaobai.mapper.DishMapper;
import com.xiaobai.service.DishFlavorService;
import com.xiaobai.service.DishService;
import com.xiaobai.util.R;
import com.xiaobai.vo.DishVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    private CategoryMapper categoryMapper;
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

    @Override
    public R<Page> getPage(int page, int pageSize, String name) {
        //构造分页构造器对象
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishVo> dishDtoPage = new Page<>();

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, Dish::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Dish::getUpdateTime);

        //执行分页查询
        dishMapper.selectPage(pageInfo, queryWrapper);
        // dishService.page(pageInfo,queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");
        List<Dish> records = pageInfo.getRecords();
        List<DishVo> list = records.stream().map((item) -> {
            DishVo dishDto = new DishVo();
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId();//分类id
            //根据id查询分类对象
            Category category = categoryMapper.selectById(categoryId);
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(list);
        return R.success(dishDtoPage);
    }

    @Override
    public R<DishVo> getDishInfo(Long id) {
        //查询菜品基本信息，从dish表查询
        Dish dish = this.getById(id);

        DishVo dishVo = new DishVo();
        BeanUtils.copyProperties(dish, dishVo);

        //查询当前菜品对应的口味信息，从dish_flavor表查询
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishVo.setFlavors(flavors);

        return R.success(dishVo);
    }

    @Override
    @Transactional
    public void updateWithFlavor(DishVo dishVo) {
        //更新dish表基本信息
        this.updateById(dishVo);

        //清理当前菜品对应口味数据---dish_flavor表的delete操作
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(DishFlavor::getDishId,dishVo.getId());

        dishFlavorService.remove(queryWrapper);

        //添加当前提交过来的口味数据---dish_flavor表的insert操作
        List<DishFlavor> flavors = dishVo.getFlavors();

        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishVo.getId());
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
    }

}
