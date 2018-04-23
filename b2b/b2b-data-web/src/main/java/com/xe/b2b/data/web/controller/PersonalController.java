package com.xe.b2b.data.web.controller;

import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IUserService;
import com.xe.b2b.data.business.service.conf.AppConfig;
import com.xe.b2b.data.business.service.conf.AppConfigHolder;
import com.xe.b2b.data.common.contants.HttpCode;
import com.xe.b2b.data.common.util.ConstantUtils;
import com.xe.b2b.data.common.util.SecurityUtil;
import com.xe.b2b.data.web.common.IpUtils;
import com.xe.b2b.data.web.contants.WEBConstants;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/personal")
public class PersonalController extends BaseController {
    @Resource
    private IUserService userService;
    @Resource
    private AppConfig config;

    private static final Logger logger = LogManager.getLogger(PersonalController.class);

    @RequestMapping("/outlogin")
    public String outlogin(HttpServletRequest request) {
        logger.info(formatLog(request, ""));
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            request.getSession().removeAttribute(ConstantUtils.USERINFO);
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
            map.put(HttpCode.HTTP_MSG_KEY, "退出成功");
        } catch (Exception e) {
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            map.put(HttpCode.HTTP_MSG_KEY, "登录失败");
            logger.error("退出失败, 服务器错误", e);
        }
        return "personal/login";
    }

    @RequestMapping("/info")
    public String details(HttpServletRequest request, ModelMap map) {
        logger.info(formatLog(request, ""));
        UserEntity currentUser = getcurrentUser(request);
        if (currentUser != null) {

            UserEntity sysuser = userService.get(currentUser.getWorkId());
            if (sysuser != null) {
                request.getSession().setAttribute(ConstantUtils.USERINFO, sysuser);
                map.put("sysuser", sysuser);
                map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
            } else {
                map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                map.put(HttpCode.HTTP_MSG_KEY, "系统错误！");
            }
        }
        return "personal/info";
    }

    @RequestMapping("/updpwd")
    public String add(HttpServletRequest request, ModelMap map) {
        logger.info(formatLog(request, ""));
        try {
            map.put("code", HttpCode.HTTP_CODE_200);
            map.put("msg", "初始化数据成功");
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }

        return "personal/updpwd";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(String userName, String passWord, HttpServletRequest request) {
        logger.info("ip: " + IpUtils.getIpAddress(request) + "; user: " + request.getRequestURL() + "; params: "
                + userName + ", " + passWord);
        Map<String, Object> map = new HashMap<String, Object>();
        AppConfigHolder.appConfig = config;
        try {
            logger.info("userName:" + userName + "   password:" + passWord);
            if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(passWord)) {
                UserEntity user = new UserEntity();
                user.setWorkId(userName);
                user.setPassword(passWord);
                if (!WEBConstants.securityCode.equals(AppConfigHolder.appConfig.getSecurityCode())
                        && SecurityUtil.hasExpired()) {
                    map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                    map.put(HttpCode.HTTP_MSG_KEY, "系统已经过期！");
                } else {
                    UserEntity sysuser = userService.login(user);
                    if (sysuser != null) {
                        request.getSession().setAttribute(ConstantUtils.USERINFO, sysuser);
                        map.put("sysuser", sysuser);
                        map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                        map.put(HttpCode.HTTP_MSG_KEY, "登录成功");
                    } else {
                        map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                        map.put(HttpCode.HTTP_MSG_KEY, "用户名或密码不正确");
                    }
                }
            } else {
                map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                map.put(HttpCode.HTTP_MSG_KEY, HttpCode.HTTP_MSG_400);
            }
        } catch (Exception e) {
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            map.put(HttpCode.HTTP_MSG_KEY, "登录失败");
            logger.error("登录失败 服务器错误", e);
        }
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, UserEntity sysuser) {
        logger.info(formatLog(request, sysuser));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "更新";
        UserEntity currentUser = getcurrentUser(request);
        String phone = currentUser.getPhone();
        String email = currentUser.getEmail();
        try {
            if (StringUtils.isNotBlank(phone) && StringUtils.isNotBlank(email) && phone.equals(sysuser.getPhone())
                    && email.equals(sysuser.getEmail())) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                result.put(HttpCode.HTTP_MSG_KEY, "没有内容需要更新！");
                return result;
            }
            sysuser.setWorkId(currentUser.getWorkId());
            boolean value = userService.update(sysuser);
            if (value) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                result.put(HttpCode.HTTP_MSG_KEY, msg + "成功！");
            } else {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, msg + "失败！");
            }
        } catch (Exception e) {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, msg + "失败！");
            logger.error(msg + "失败！", e);
        }
        return result;
    }

    /**
     * 修改密码
     * 
     * @param id
     * @param pwd
     * @param request
     * @return
     */
    @RequestMapping(value = "/updpwd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updpwd(String oldpwd, String newpwd, HttpServletRequest request) {
        logger.info(formatLog(request, oldpwd + ", " + newpwd));
        Map<String, Object> result = new HashMap<String, Object>();
        UserEntity currentUser = getcurrentUser(request);

        String workId = currentUser.getWorkId();
        try {
            if (StringUtils.isNotBlank(workId) && StringUtils.isNotBlank(oldpwd) && StringUtils.isNotBlank(newpwd)) {
                boolean value = userService.editPassword(workId, oldpwd, newpwd);
                if (value) {
                    result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                    result.put(HttpCode.HTTP_MSG_KEY, "重置密码成功！");
                } else {
                    result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                    result.put(HttpCode.HTTP_MSG_KEY, HttpCode.HTTP_MSG_400);
                }
            } else {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, HttpCode.HTTP_MSG_400);
            }
        } catch (Exception e) {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "重置密码错误！");
            logger.error("重置密码错误workId" + workId + ":", e);
        }
        return result;
    }

}
