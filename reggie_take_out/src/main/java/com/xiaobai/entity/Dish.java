package com.xiaobai.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 13:32:11
 * @Version 1.0
 * @ClassName Dish
 * @Description 类方法说明：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "dish")
public class Dish  implements Serializable {
    public static final long serialVersionUID = 1L;
    // 主键
    @TableId(type = IdType.AUTO)
    private Long id;
    // 菜品名称
    private String name;
    // 菜品分类id
    private Long categoryId;
    // 菜品价格
    private Double price;
    // 商品码
    private String code;
    // 图片
    private String image;
    // 描述信息
    private String description;
    // 0 停售 1 起售
    private Integer status;
    // 顺序
    private Integer sort;
    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    // 创建人
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
    // 修改人
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;
    // 是否删除
    private Integer isDeleted;

}
