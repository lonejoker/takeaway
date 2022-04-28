package com.xiaobai.vo;

import com.xiaobai.entity.Dish;
import com.xiaobai.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 15:06
 * @Version 1.0
 * @ClassName DishVo
 * @Description 类方法说明：
 */
@Data
public class DishVo extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}