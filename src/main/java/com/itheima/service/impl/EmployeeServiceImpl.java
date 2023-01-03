package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.domain.Employee;
import com.itheima.domain.PageBean;
import com.itheima.mapper.EmployeeMapper;
import com.itheima.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: hsp
 * @Date: 2022/12/18-12-18-21:43
 * @Description: com.itheima.service.impl
 * @version: 1.0.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    private HashMap<Integer, Employee> cache = new HashMap<Integer, Employee>();

    //查询所有员工列表+分页显示
    @Override
    public PageBean<Employee> findAll(PageBean<Employee> pageBean, Employee employee) {
        //1. 接收 当前页码
        Integer currentPage = pageBean.getCurrentPage();

        //2. 接收 每页展示条数
        Integer pageSize = pageBean.getPageSize();

        //创建新的PageBean对象
        PageBean<Employee> pb = new PageBean<Employee>();

        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        //4. 按页查询员工数据
        //条件构造器
        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<>();
        String lastName = employee.getLastName();
        Integer deptId = employee.getDeptId();
        lqw.like(Employee::getLastName, lastName).or().eq(Employee::getDeptId, deptId);

        //计算开始索引
        Integer start = (currentPage - 1) * pageSize;
        System.out.println("---------start------->"+start);
        //分页构造器
        IPage<Employee> page = new Page<>(start, pageSize);
        employeeMapper.selectPage(page, lqw);

        Long _totalRecords = page.getTotal();
        Integer totalRecords = _totalRecords.intValue();
        pb.setTotalRecords(totalRecords);

        Long _totalPage = page.getPages();
        Integer totalPage = _totalPage.intValue();
        pb.setTotalPage(totalPage);

        List<Employee> records = page.getRecords();
        pb.setRecords(records);

        return pb;
    }

    //添加员工
    @Override
    public void save(Employee employee) {
        employeeMapper.insert(employee);
    }

    //根据id查询员工信息
    @Override
    public Employee findById(Integer id) {
        //从缓存中获取数据
        Employee employee = cache.get(id);
        if (employee == null){
            //从数据库查询
            Employee quaryEmployee = employeeMapper.selectById(id);
            //放到缓存中
            cache.put(id, quaryEmployee);
            return quaryEmployee;
        }
        return cache.get(id);
    }

    //根据员工id修改员工
    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateById(employee);
    }

    //删除单个员工
    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteById(id);
    }

    //批量删除员工
    @Override
    public void deleteBatchEmployee(String[] eids) {
        if (eids != null && eids.length>0){
            for (String eid : eids) {
                employeeMapper.deleteById(eid);
            }
        }
    }

}
