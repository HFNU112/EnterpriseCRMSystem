package com.itheima.controller;

import com.itheima.domain.Department;
import com.itheima.domain.Employee;
import com.itheima.domain.PageBean;
import com.itheima.service.DepartmentService;
import com.itheima.service.EmployeeService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.awt.SunHints;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @Author: hsp
 * @Date: 2022/12/18-12-18-21:22
 * @Description: com.itheima.controller
 * @version: 1.0.0
 */
@Controller
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @Resource
    private DepartmentService departmentService;

    //查询所有员工+分页查询
    @GetMapping("/emps")
    public String findAll(Model model, PageBean<Employee> pageBean, Employee employee) {
        //默认设置在第1页，每页显示5条数据
        if (pageBean.getCurrentPage()==null || "".equals(pageBean.getCurrentPage())){
            pageBean.setCurrentPage(1);
        }
        if (pageBean.getPageSize()==null || "".equals(pageBean.getPageSize())){
            pageBean.setPageSize(7);
        }
        //查询所有的员工+分页对象
        PageBean<Employee> pb = employeeService.findAll(pageBean, employee);
        System.out.println("----------pb--------->"+pb);
        List<Department> depts = departmentService.findAll();
        //将员工对象放到请求域中
        model.addAttribute("pb", pb);
        model.addAttribute("depts", depts);
        model.addAttribute("emp", employee);

        //返回员工列表页面
        return "emp/employ_list";
    }

    //跳转到添加页面
    @GetMapping("/emp")
    public String toSavePage(Model model){
        //查询所有部门列表
        List<Department> departments = departmentService.findAll();
        model.addAttribute("depts", departments);
        return "emp/employ_add";
    }

    //添加员工
    @PostMapping("/emp")
    public String save(Employee employee){
        System.out.println("--------添加员工---------"+employee);
        //保存员工信息
        employeeService.save(employee);
        //返回员工列表页面1、重定向redirect  2、转发forward
        return "redirect:/emps";
    }

    //来到修改页面并回显员工信息
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        //根据id查询员工信息
        Employee employee = employeeService.findById(id);
        model.addAttribute("emp", employee);

        //查询所有部门列表
        List<Department> departments = departmentService.findAll();
        model.addAttribute("depts", departments);
        //返回修改页面和添加页面是同一个页面
        return "emp/employ_add";
    }

    //修改员工: 根据id修改员工
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("---------修改员工---------"+employee);
        employeeService.updateEmployee(employee);
        //返回员工查询列表页面
        return "redirect:/emps";
    }

    //删除单个员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/emps";
    }

    //批量删除员工
    @DeleteMapping("/emps")
    public String deleteBatchEmployee(HttpServletRequest request){
        //接收员工数据
        String[] eids = request.getParameterValues("eid");
        System.out.println("-----eids-------->"+eids);
        employeeService.deleteBatchEmployee(eids);
        return "redirect:/emps";
    }


}
