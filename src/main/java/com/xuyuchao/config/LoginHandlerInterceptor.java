package com.xuyuchao.config;

import org.apache.catalina.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-22:30
 * @Description: 配置拦截器,实现HandlerInterceptor接口
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session中的用户信息
        Object username = request.getSession().getAttribute("username");
        if(username == null) {
            request.setAttribute("msg","没有权限,请先登录!");
            //转发到登录页面
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
