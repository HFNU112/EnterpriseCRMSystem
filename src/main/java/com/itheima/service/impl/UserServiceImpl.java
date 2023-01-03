package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: hsp
 * @Date: 2022/12/18-12-18-16:45
 * @Description: com.itheima.service.impl
 * @version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        //根据用户名和密码查询数据库
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User ::getUsername, username).eq(User::getPassword, password);

        //返回查询的user对象
        return userMapper.selectOne(lqw);
    }
}
