package com.itheima.common;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.itheima.intercepter.LoginHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: hsp
 * @Date: 2022/12/17-12-17-19:16
 * @Description: com.itheima.common
 * @version: 1.0.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //将组件注册到容器
    @Bean
    public WebMvcConfigurer webMvcConfigurerA() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //添加内部拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //拦截: 静态资源 *.css  *.js  img
                //springboot配置静态资源映射
                registry.addInterceptor(new LoginHandlerIntercepter())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/", "/login.html", "/admin/user/login", "/asserts/**","/webjars/**");
            }

        };
        return configurer;
    }

    //国际化区域信息解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
