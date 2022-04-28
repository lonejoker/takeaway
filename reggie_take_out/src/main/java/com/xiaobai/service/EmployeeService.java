package com.xiaobai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.entity.Employee;
import com.xiaobai.util.R;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 09:59:29
 * @Version 1.0
 * @ClassName Employee
 * @Description 类方法说明：
 */
public interface EmployeeService extends IService<Employee> {

    R<Employee> login(HttpServletRequest request, Employee employee);

    R<String> logout(HttpServletRequest request);

    R<String> saveUser(HttpServletRequest request, Employee employee);

    R<Page> pageInfo(int page, int pageSize, String name);
}
