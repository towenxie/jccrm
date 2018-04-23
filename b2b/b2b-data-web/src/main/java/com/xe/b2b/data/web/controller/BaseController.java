package com.xe.b2b.data.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.web.common.IpUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础数据
 * 
 * @author bgt
 * 
 */
public class BaseController {

    public static final Logger logger = LogManager.getLogger(BaseController.class);

    public String formatLog(HttpServletRequest request, Object params){
        return "ip: "+IpUtils.getIpAddress(request)+"; user: "+getcurrentUser(request).getWorkId() + "; url: "+ request.getRequestURL() +"; params: " + params.toString();
    }
    public UserEntity getcurrentUser(HttpServletRequest request) {
        UserEntity user = (UserEntity) WebUtils.getSessionAttribute(request, "userInfo");
        // UserEntity user=(UserEntity)request.getSession().getAttribute("userInfo");
        return user;
    }

    public void setSessionValue(HttpServletRequest request, String key, String value) {
        WebUtils.setSessionAttribute(request, key, value);
        // request.getSession().setAttribute(key, value);
    }

    public String getSessionValue(HttpServletRequest request, String key) {
        return String.valueOf(request.getSession().getAttribute(key));
    }

    protected Map<String, Object> success() {
        return success(null);
    }

    protected Map<String, Object> success(String msg) {
        return success(msg, null);
    }

    protected Map<String, Object> success(String msg, Object data) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", HttpStatus.OK.value());
        // resultMap.put("msg", StringUtils.isEmpty(msg)?HttpStatus.OK.getReasonPhrase():msg);
        resultMap.put("msg", StringUtils.isEmpty(msg) ? "操作成功！" : msg);
        resultMap.put("data", data);
        return resultMap;
    }

    protected Map<String, Object> error() {
        return error(null);
    }

    protected Map<String, Object> error(String msg) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultMap.put("msg", StringUtils.isEmpty(msg) ? HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() : msg);
        return resultMap;
    }


    /** 基于@ExceptionHandler异常处理 */
    @ExceptionHandler
    public String exp(HttpServletRequest request, HttpServletResponse response, Exception ex) throws Exception {
        logger.error("请求异常：" + ex);
        // 判断是否ajax请求
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            response.setCharacterEncoding("UTF-8");
            JSONObject object = new JSONObject();
            // object.put("msg", ex.toString());
            object.put("msg", "系统异常！");
            PrintWriter out = response.getWriter();
            out.println(object);
        } else {
            request.setAttribute("ex", ex);
            return "/error/500";
        }
        return null;
    }
}
