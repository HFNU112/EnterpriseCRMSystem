package com.itheima.service;

import com.itheima.domain.User;

/**
 * @Author: hsp
 * @Date: 2022/12/18-12-18-16:44
 * @Description: com.itheima.service
 * @version: 1.0.0
 */
public interface UserService {

    //根据用户名和密码查询用户信息
    User login(String username, String password);

}
