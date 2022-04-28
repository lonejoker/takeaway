package com.xiaobai.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaobai.entity.Category;
import com.xiaobai.service.CategoryService;
import com.xiaobai.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 12:13:55
 * @Version 1.0
 * @ClassName Category
 * @Description 类方法说明：
 */
@RestController
@Slf4j
@RequestMapping("/category")
public class CategoryController implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/page")
    public R<Page> pageInfo(int page, int pageSize) {
        return categoryService.pageInfo(page, pageSize);
    }

    @DeleteMapping
    public R<String> deleteCategory(Long ids) {
        return categoryService.deleteCategory(ids);
    }

    @PutMapping
    public R<String> updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @GetMapping("/list")
    public R<List<Category>> categoryList(Category category){
        return categoryService.categoryList(category);
    }


}
