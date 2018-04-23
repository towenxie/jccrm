/**
 * @ProjectName b2b-data-web
 * @FileName LoginInterceptor.java
 * @PackageName com.xe.b2b.data.web
 * @Date 2017年10月5日上午9:35:02
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录认证的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        response.setHeader("progma","no-cache");  
        response.setHeader("Cache-Control","no-cache");  
        response.setDateHeader("Expires",0);
    }

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = ((HttpServletRequest) request).getServletPath();
        if (url.equals("/") || url.equals("/personal/login")) {
            // if(url.indexOf("login.action")>=0){
            return true;
        }
        // 获取Session
        HttpSession session = request.getSession();
        Object object = session.getAttribute("userInfo");
        if (object != null) {
            return true;
        }
        // 不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/").forward(request, response);

        return false;
    }

}
