package com.xiaobai.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaobai.entity.Employee;
import com.xiaobai.service.EmployeeService;
import com.xiaobai.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 10:00:57
 * @Version 1.0
 * @ClassName Employee
 * @Description 类方法说明：
 */
@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        return employeeService.login(request, employee);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        return employeeService.logout(request);
    }

    @PostMapping
    public R<String> saveUser(HttpServletRequest request, @RequestBody Employee employee) {
        return employeeService.saveUser(request, employee);
    }

    @GetMapping("/page")
    public R<Page> pageInfo(int page, int pageSize, String name) {
        return employeeService.pageInfo(page, pageSize, name);
    }

    @PutMapping
    public R<String> updateStatus(HttpServletRequest request, @RequestBody Employee employee) {
        return employeeService.updateStatus(request, employee);
    }

    @GetMapping("/{id}")
    public R<Employee> getUserById(@PathVariable Long id) {
        return employeeService.getUserById(id);
    }
}
