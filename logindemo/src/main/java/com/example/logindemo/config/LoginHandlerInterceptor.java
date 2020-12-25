/**
 * @projectName logindemo
 * @package com.example.logindemo.config
 * @className com.example.logindemo.config.LoginHandlerInterceptor
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.logindemo.config;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginHandlerInterceptor
 * @description 登录拦截器
 * @author lichengyong
 * @date 2020/12/25 14:58
 * @version 1.0
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //重写拦截器的preHandle，postHandle，afterCompletion
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("userName");  //需要在loginController中把用户名放进session里
        System.out.println("preHandle----" + user + " ::: " + request.getRequestURL());
        if(null == user){
            request.setAttribute("msg","请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        Object user = request.getSession().getAttribute("username");  //需要在loginController中设置这个session值
        System.out.println("postHandle----" + user + " ::: " + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        Object user = request.getSession().getAttribute("username");  //需要在loginController中设置这个session值
        System.out.println("afterCompletion----" + user + " ::: " + request.getRequestURL());
    }
}