package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 管理端登录
 * @Author: hsp
 * @Date: 2022/12/18-12-18-16:29
 * @Description: com.itheima.controller
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    private UserService userService;

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login (@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Map<String, Object> map, HttpSession session){

        User user = userService.login(username, password);
        if (user != null){
            //将User信息放到session中
            session.setAttribute("loginUser", username);
            //登录成功: 防止刷新页面表单重复提交？ 重定向redirect
            return "redirect:/main.html";
        }else {
            //登录失败，并给出错误提示信息？ 重定向
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }

}
