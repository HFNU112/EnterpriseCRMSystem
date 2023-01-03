package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: hsp
 * @Date: 2022/12/18-12-18-17:51
 * @Description: com.itheima.mapper
 * @version: 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
