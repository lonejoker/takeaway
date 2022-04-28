package com.xiaobai.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 09:52:28
 * @Version 1.0
 * @ClassName Employee
 * @Description 类方法说明：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "employee")
public class Employee implements Serializable {
    public static final long serialVersionUID = 1L;
    // 主键
    @TableId(type = IdType.AUTO)
    private Long id;
    // 姓名
    private String name;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 手机号
    private String phone;
    // 性别
    private String sex;
    // 身份证号
    private String idNumber;
    // 状态 0:禁用，1:正常
    private Integer status;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 创建人
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
    // 修改人
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUser;

}
