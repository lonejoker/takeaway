package com.xiaobai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.config.CustomException;
import com.xiaobai.entity.Category;
import com.xiaobai.entity.Dish;
import com.xiaobai.entity.Setmeal;
import com.xiaobai.mapper.CategoryMapper;
import com.xiaobai.mapper.DishMapper;
import com.xiaobai.mapper.SetmealMapper;
import com.xiaobai.service.CategoryService;
import com.xiaobai.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 12:13:55
 * @Version 1.0
 * @ClassName Category
 * @Description 类方法说明：
 */
@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public R<String> saveCategory(Category category) {
        log.info("category:{}", category);
        categoryMapper.insert(category);
        return R.success("新增分类成功");
    }

    @Override
    public R<Page> pageInfo(int page, int pageSize) {
        //分页构造器
        Page<Category> pageInfo = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(Category::getSort);

        //分页查询
        categoryMapper.selectPage(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    @Override
    public R<String> deleteCategory(Long ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        int count1 = dishMapper.selectCount(dishLambdaQueryWrapper);

        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if (count1 > 0) {
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        int count2 = setmealMapper.selectCount(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        //正常删除分类
        categoryMapper.deleteById(ids);
        return R.success("删除成功");
    }

    @Override
    public R<String> updateCategory(Category category) {
        log.info("修改分类信息：{}", category);
        categoryMapper.updateById(category);
        return R.success("修改分类信息成功");
    }

    @Override
    public R<List<Category>> categoryList(Category category) {
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryMapper.selectList(queryWrapper);
        return R.success(list);
    }

}
