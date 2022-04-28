package com.xiaobai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.entity.Category;
import com.xiaobai.util.R;

import java.util.List;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 12:13:55
 * @Version 1.0
 * @ClassName Category
 * @Description 类方法说明：
 */
public interface CategoryService extends IService<Category> {

    R<String> saveCategory(Category category);

    R<Page> pageInfo(int page, int pageSize);

    R<String> deleteCategory(Long ids);

    R<String> updateCategory(Category category);

    R<List<Category>> categoryList(Category category);
}
