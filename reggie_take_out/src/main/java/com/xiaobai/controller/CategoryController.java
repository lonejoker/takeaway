package com.xiaobai.controller;


import com.xiaobai.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

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
public class CategoryController implements Serializable{
    public static final long serialVersionUID = 1L;
    
    @Autowired
    private CategoryService categoryService;
    
    
}
