package com.xiaobai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.entity.Category;
import com.xiaobai.mapper.CategoryMapper;
import com.xiaobai.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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

}
