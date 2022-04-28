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
 * @create 2022-04-28 12:13:55
 * @Version 1.0
 * @ClassName Category
 * @Description 类方法说明：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "category")
public class Category implements Serializable {
    public static final long serialVersionUID = 1L;
    // 主键
    @TableId(type = IdType.AUTO)
    private Long id;
    // 类型   1 菜品分类 2 套餐分类
    private Integer type;
    // 分类名称
    private String name;
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

}
