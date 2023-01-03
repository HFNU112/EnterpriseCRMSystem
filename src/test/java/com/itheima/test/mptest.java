package com.itheima.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Employee;
import com.itheima.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Author: hsp
 * @Date: 2023/1/2-01-02-22:05
 * @Description: com.itheima.test
 * @version: 1.0.0
 */
public class mptest {

    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void testSelectPage() {
        IPage<Employee> page = new Page<>(2, 7);
        employeeMapper.selectPage(page, null);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }

}
