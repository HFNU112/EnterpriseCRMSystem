package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: hsp
 * @Date: 2022/12/18-12-18-16:39
 * @Description: com.itheima.domain
 * @version: 1.0.0
 */
@Data
@TableName("tb_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;  //主键id

    private String username;  //用户名

    private String password;  //密码

}
