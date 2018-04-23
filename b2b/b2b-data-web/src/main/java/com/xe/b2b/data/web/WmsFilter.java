/**
 * @ProjectName b2b-data-web
 * @FileName WmsFilter.java
 * @PackageName com.xe.b2b.data.web
 * @Date 2017年9月25日下午11:07:39
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

/**
 * @ClassName WmsFilter
 * @Description TODO
 * @Date 2017年9月25日 下午11:07:39
 * @author towen
 * @version v1.0
 */
public class WmsFilter implements Filter {
    // 日志
    private static final Logger logger = LogManager.getLogger(WmsFilter.class);


    public void destroy() {
        // TODO Auto-generated method stub
    }


    public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain chain)
            throws IOException, ServletException {
        String path = ((HttpServletRequest) sreq).getServletPath();
        if (path.equals("/")) {
            chain.doFilter(sreq, sresp);
        } else {
            if (!(sreq instanceof HttpServletRequest) || !(sresp instanceof HttpServletResponse)) {
                throw new ServletException("OncePerRequestFilter just supports HTTP requests");
            }
            HttpServletRequest httpRequest = (HttpServletRequest) sreq;
            HttpServletResponse httpResponse = (HttpServletResponse) sresp;
            httpResponse.setHeader("Cache-Control", "no-cache");
            httpResponse.setHeader("Pragma", "no-cache");
            httpResponse.setDateHeader("Expires", -1);
            httpResponse.setHeader("P3P", "CP=CAO PSA OUR");

            HttpSession session = httpRequest.getSession();
            if (!httpResponse.isCommitted()) {
                if (session != null) {
                    Object object = session.getAttribute("userInfo");
                    if (object == null) {
                        boolean isAjaxRequest = isAjaxRequest(httpRequest);
                        if (isAjaxRequest) {
                            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
                        }
                        httpResponse.sendRedirect("/b2b-data-web/");
                    }
                } else {
                    httpResponse.sendRedirect("/b2b-data-web/");
                }
            }
            chain.doFilter(sreq, sresp);
        }
    }


    /**
     * 判断是否为Ajax请求
     * 
     * @param request HttpServletRequest
     * @return 是true, 否false
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }


    public void init(FilterConfig config) throws ServletException {}
}
