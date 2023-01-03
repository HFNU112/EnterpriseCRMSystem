package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: hsp
 * @Date: 2022/12/17-12-17-18:18
 * @Description: com.itheima.mapper
 * @version: 1.0.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
