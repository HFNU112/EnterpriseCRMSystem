package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 部门实体
 * @Author: hsp
 * @Date: 2022/12/17-12-17-18:17
 * @Description: com.itheima.domain
 * @version: 1.0.0
 */
@Data
@TableName("tb_department")
public class Department implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;   //部门id

    private String departmentName;  //部门名称

}
