package com.itheima.service;

import com.itheima.domain.Department;

import java.util.List;

/**
 * @Author: hsp
 * @Date: 2022/12/21-12-21-17:46
 * @Description: com.itheima.service
 * @version: 1.0.0
 */
public interface DepartmentService {

    //查询所有部门
    List<Department> findAll();

}
