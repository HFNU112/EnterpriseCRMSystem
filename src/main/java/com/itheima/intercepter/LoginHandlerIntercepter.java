package com.itheima.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @Author: hsp
 * @Date: 2022/12/18-12-18-18:56
 * @Description: com.itheima.intercepter
 * @version: 1.0.0
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {

    //执行目标方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            //没有登录，去登录返回到登录页面; 请求转发到 login.html
            request.setAttribute("msg", "您还没有权限访问, 请先登录！");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }else {
            //已登录, 放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
