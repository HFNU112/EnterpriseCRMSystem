package com.itheima.common;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mp分页插件
 * @Author: hsp
 * @Date: 2022/12/30-12-30-22:50
 * @Description: com.itheima.common
 * @version: 1.0.0
 */
@Configuration
public class MpConfig {

    @Bean
    public MybatisPlusInterceptor mpInterceptor() {
        //定义mp拦截器
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        //添加具体拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(-1L);
        mpInterceptor.addInnerInterceptor(paginationInnerInterceptor);

        return mpInterceptor;
    }

}
