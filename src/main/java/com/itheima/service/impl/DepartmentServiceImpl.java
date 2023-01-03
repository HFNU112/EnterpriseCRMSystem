package com.itheima.service.impl;

import com.itheima.domain.Department;
import com.itheima.mapper.DepartmentMapper;
import com.itheima.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hsp
 * @Date: 2022/12/21-12-21-17:47
 * @Description: com.itheima.service.impl
 * @version: 1.0.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    //查询所有部门
    @Override
    public List<Department> findAll() {
        return departmentMapper.selectList(null);
    }

}
