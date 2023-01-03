package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Employee;
import com.itheima.domain.PageBean;

import java.util.List;

/**
 * @Author: hsp
 * @Date: 2022/12/18-12-18-21:43
 * @Description: com.itheima.service
 * @version: 1.0.0
 */
public interface EmployeeService {

    //查询所有员工列表+分页查询
    PageBean<Employee> findAll(PageBean<Employee> pageBean,Employee employee);

    //添加员工
    void save(Employee employee);

    //根据id查询员工信息
    Employee findById(Integer id);

    //修改员工列表
    void updateEmployee(Employee employee);

    //删除单个员工
    void deleteEmployee(Integer id);

    //批量删除员工
    void deleteBatchEmployee(String[] eids);

}
