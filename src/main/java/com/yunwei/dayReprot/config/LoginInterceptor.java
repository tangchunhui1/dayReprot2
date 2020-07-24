package com.yunwei.dayReprot.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor
        implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
            System.out.println("登陆拦截器1执行,请求地址:" + request.getRequestURI() + "  AJAX请求放行");
            return true;
        }

        if ("true".equals(request.getHeader("isWX"))) {

            System.out.println(request.getHeader("isWX"));

            System.out.println("登陆拦截器1执行,请求地址:" + request.getRequestURI() + "  WX请求放行");

            return true;
        }

        System.out.println("登陆拦截器1执行,请求地址:" + request.getRequestURI());


        Object loginName = request.getSession().getAttribute("loginName");


        if (loginName == null || !(loginName instanceof String)) {
            System.out.println("当前用户未登录,跳转登录页面");

            response.sendRedirect("/");
            return false;
        }
        String userName = (String) loginName;
        System.out.println("当前用户已登录，登录的用户名为： " + userName);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}


