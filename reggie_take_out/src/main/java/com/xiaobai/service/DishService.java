package com.xiaobai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.entity.Dish;
import com.xiaobai.vo.DishVo;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 13:41:14
 * @Version 1.0
 * @ClassName Dish
 * @Description 类方法说明：
 */
public interface DishService extends IService<Dish> {

    void saveDish(DishVo dishVo);
}
