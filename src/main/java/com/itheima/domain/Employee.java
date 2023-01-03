package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工实体
 * @Author: hsp
 * @Date: 2022/12/17-12-17-18:13
 * @Description: com.itheima.domain
 * @version: 1.0.0
 */
@Data
@TableName("tb_employee")
public class Employee implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;   //主键id

    private String lastName;  //姓名

    private String email;   //邮箱

    private String gender;  //性别  1: male  0: female

    private Date birth;   //出生日期

    private Integer deptId;  //部门编号

}
