package com.xe.b2b.data.web.controller;

import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.service.*;
import com.xe.b2b.data.business.service.conf.AppConfig;
import com.xe.b2b.data.business.service.conf.AppConfigHolder;
import com.xe.b2b.data.common.contants.HttpCode;
import com.xe.b2b.data.common.contants.SystemConstant;
import com.xe.b2b.data.common.util.MD5;
import com.xe.b2b.data.web.common.UploadUtils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class CommController extends BaseController {
    @Resource
    private IMenuService menuService;
    @Resource
    IUserService userService;
    @Resource
    private AppConfig config;

    public static final Logger logger =  LogManager.getLogger(BaseController.class);

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "personal/login";
    }

    @RequestMapping("/register/{moduleName}")
    public String register(@PathVariable("moduleName") String moduleName) {
        return "register/" + moduleName;
    }

    @RequestMapping("/submitReg/{moduleName}")
    @ResponseBody
    public Map<String, Object> submitReg(HttpServletRequest request, @PathVariable("moduleName") String moduleName,
                                         UserEntity userEntity) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            logger.info("提交注册信息：" + moduleName);
            UserEntity user = new UserEntity();
            String passWord = new MD5().getMD5ofStr("123456");
            user.setPassword(passWord);
            userService.insert(user);
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
            map.put(HttpCode.HTTP_MSG_KEY, "注册成功，请等待审核！");
        } catch (Exception e) {
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            map.put(HttpCode.HTTP_MSG_KEY, "操作失败,服务器错误");
        }
        return map;
    }

    @RequestMapping("/main")
    public String main(HttpServletRequest request, Model model) {
    	UserEntity currentUser = getcurrentUser(request);
        if (currentUser != null) {
            List<MenuEntity> userMenus = menuService.queryByUser(currentUser.getWorkId());
            List<MenuEntity> parentMenus = menuService.queryAllNullParent();
            List<MenuEntity> menus = new ArrayList<MenuEntity>();
            for (MenuEntity menu : parentMenus) {
                if (StringUtils.isBlank(menu.getParentCode())) {
                    List<MenuEntity> sonMenus = new ArrayList<MenuEntity>();
                    for (MenuEntity m : userMenus) {
                        if (menu.getCode().equals(m.getParentCode())) {
                            sonMenus.add(m);
                        }else if (menu.getCode().equals(m.getCode())) {
                        	sonMenus = menu.getMenus();
    					}
                    }
                    if (CollectionUtils.isNotEmpty(sonMenus)) {
                        menu.setMenus(sonMenus);
                        menus.add(menu);
					}
                }
            }
            String title = "嘉辰CRM平台";
            title = SystemConstant.PLATFORM_NAME;
            model.addAttribute("title", title);
            model.addAttribute("records", menus);
            return "comm/main";
        } else {
            return "personal/login";
        }
    }

    @RequestMapping("/lasturl")
    @ResponseBody
    public Map<String, Object> lasturl(HttpServletRequest request, String lasturl) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtils.isEmpty(lasturl)) {
            lasturl = "/main";
        }
        request.getSession().setAttribute("lasturl", lasturl);
        result.put("msg", "存放成功");
        return result;
    }


    @RequestMapping(value = "/uploadimg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadimg(HttpServletRequest request,@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        AppConfigHolder.appConfig = config;
        logger.info("上传图片");
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            if (StringUtils.isNotBlank(AppConfigHolder.appConfig.getUploadPath())) {
                realPath = AppConfigHolder.appConfig.getUploadPath();
            }
        try {
            String path=UploadUtils.imageHandle(file,realPath);
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
            map.put(HttpCode.HTTP_MSG_KEY, "上传成功");
            map.put("url",path);
        } catch (Exception e) {
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            map.put(HttpCode.HTTP_MSG_KEY, "上传失败");
            logger.error("上传失败", e);
        }
        return map;
    }
}
