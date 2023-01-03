package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author: hsp
 * @Date: 2022/12/17-12-17-12:43
 * @Description: com.itheima.controller
 * @version: 1.0.0
 */
@Controller
public class HelloController {

   /* @RequestMapping({"/","/index.html"})
    public String index () {
        return "index";
    }*/

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/success")
    //classpath:/templates/success.html
    public String success(Map<String, Object> map){
        map.put("username", "你好, thymeleaf");
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }

    @PutMapping("/demo")
    @ResponseBody
    public String demo(){
        return "success";
    }

}
