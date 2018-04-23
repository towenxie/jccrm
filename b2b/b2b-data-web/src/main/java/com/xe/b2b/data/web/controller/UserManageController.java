package com.xe.b2b.data.web.controller;

import com.xe.b2b.data.access.model.DeptEntity;
import com.xe.b2b.data.access.model.RoleEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IDeptService;
import com.xe.b2b.data.business.service.IRoleService;
import com.xe.b2b.data.business.service.IUserRoleService;
import com.xe.b2b.data.business.service.IUserService;
import com.xe.b2b.data.common.contants.HttpCode;
import com.xe.b2b.data.common.util.Page;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usermanage")
public class UserManageController extends BaseController {
    @Resource
    private IRoleService roleService;
    @Resource
    private IDeptService deptService;
    @Resource
    private IUserRoleService userRoleService;
    @Resource
    private IUserService userService;

    private static final Logger logger = LogManager.getLogger(UserManageController.class);

    /**
     * 编辑更新初始化
     * 
     * @param request
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/updateInit")
    public String updateInit(HttpServletRequest request, @RequestParam(value = "workId") String workId, ModelMap map) {
        logger.info(formatLog(request, workId));
        List<RoleEntity> roles = roleService.selectAll();
        if (StringUtils.isNotBlank(workId)) {
            UserEntity userModel = userService.get(workId);
            if (userModel != null) {
                map.put("sysuser", userModel);
            }

            for (RoleEntity roleEntity : roles) {
                for (RoleEntity user : userModel.getRoles()) {
                    if (user.getCode().equals(roleEntity.getCode())) {
                        roleEntity.setIsSelected(true);
                    }
                }
            }
        }
        if (CollectionUtils.isNotEmpty(roles)) {
            map.put("roles", roles);
        }

        List<DeptEntity> depts = deptService.selectDeptAll();
        if (CollectionUtils.isNotEmpty(depts)) {
            map.put("depts", depts);
        }

        return "usermanage/sysuser_editinfo";
    }

    /**
     * 根据ID查询用户详情
     * 
     * @param request
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/details")
    public String details(HttpServletRequest request, @RequestParam(value = "id") String id, ModelMap map) {
        logger.info(formatLog(request, id));
        UserEntity userModel = userService.get(id);
        if (userModel != null) {
            map.put("sysuser", userModel);
        }
        return "usermanage/sysuser_info";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, UserEntity sysuser) {
        logger.info(formatLog(request, sysuser));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "更新";
        if (StringUtils.isNotBlank(sysuser.getParentWorkId())) {
            UserEntity old = userService.get(sysuser.getParentWorkId().toUpperCase());
            if (old == null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "上级领导不存在，请更改！");
                return result;
            }
        } else {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "上级领导不能为空，请更改！");
            return result;
        }
        UserEntity currentUser = getcurrentUser(request);
        sysuser.setUpdatedBy(currentUser.getWorkId());

        try {
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
     * 添加/更新初始化
     * 
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/addInit")
    public String init(HttpServletRequest request, ModelMap map) {
        logger.info(formatLog(request, ""));
        List<RoleEntity> roles = roleService.selectAll();
        if (CollectionUtils.isNotEmpty(roles)) {
            map.put("roles", roles);
        }
        return "usermanage/add";
    }

    /**
     * 分页查询
     *
     * @param request
     * @param pageNo
     * @param map
     * @return
     */
    @RequestMapping("/querybypage")
    public String querybypage(HttpServletRequest request,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
            @RequestParam(value = "workId", defaultValue = "") String workId,
            @RequestParam(value = "userName", defaultValue = "") String userName,
            @RequestParam(value = "roleCode", defaultValue = "") String roleCode,
            @RequestParam(value = "deptCode", defaultValue = "") String deptCode, ModelMap map) {
        try {
            Page<UserEntity> page = new Page<UserEntity>();
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            if (StringUtils.isNotBlank(workId)) {
                page.getParams().put("workId", workId);
            }
            if (StringUtils.isNotBlank(userName)) {
                page.getParams().put("username", userName);
            }
            if (StringUtils.isNotBlank(roleCode)) {
                page.getParams().put("roleCode", roleCode);
            }
            if (StringUtils.isNotBlank(deptCode)) {
                page.getParams().put("deptCode", deptCode);
            }
            logger.info(formatLog(request, page));
            List<UserEntity> users = userService.queryByPage(page);
            if (CollectionUtils.isNotEmpty(users)) {
                map.put("users", users);
            }
            page.setResults(users);
            List<DeptEntity> depts = deptService.selectDeptAll();
            if (CollectionUtils.isNotEmpty(depts)) {
                map.put("depts", depts);
            }
            List<RoleEntity> roles = roleService.selectAll();
            map.put("roles", roles);
            map.put("workId", workId);
            map.put("userName", userName);
            map.put("roleCode", roleCode);
            map.put("deptCode", deptCode);
            map.put("page", page);
            map.put("code", HttpCode.HTTP_CODE_200);
            map.put("msg", "初始化后台用户成功");
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "usermanage/sysuser_list";
    }

    @ResponseBody
    @RequestMapping("/userinfo")
    public Map<String, Object> userinfo(HttpServletRequest request, String userId) {
        logger.info(formatLog(request, userId));
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isNotBlank(userId)) {
                UserEntity sysuser = userService.get(userId);
                map.put("sysuser", sysuser);
                map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
            } else {
                map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_404);
                map.put(HttpCode.HTTP_MSG_KEY, HttpCode.HTTP_MSG_404);
            }
        } catch (Exception e) {
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
            map.put(HttpCode.HTTP_MSG_KEY, HttpCode.HTTP_MSG_500);
        }
        return map;
    }

    /**
     * 添加或者更新
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addorupdate(HttpServletRequest request, UserEntity sysuser) {
        logger.info(formatLog(request, sysuser));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "添加";
        if (StringUtils.isNotBlank(sysuser.getParentWorkId())) {
            UserEntity old = userService.get(sysuser.getParentWorkId().toUpperCase());
            if (old == null && !"system".equals(sysuser.getParentWorkId().toLowerCase())) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "上级领导不存在，请更改！");
                return result;
            }
        } else {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "上级领导不能为空，请更改！");
            return result;
        }
        boolean value = false;
        String workId = sysuser.getWorkId();

        UserEntity currentUser = getcurrentUser(request);
        sysuser.setCreatedBy(currentUser.getWorkId());
        sysuser.setUpdatedBy(currentUser.getWorkId());
        if (StringUtils.isNotBlank(workId)) {
            msg = "更新";
            value = userService.update(sysuser);
        } else {
            value = userService.insert(sysuser);
        }

        try {
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
     * 删除 禁用
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> del(String id, HttpServletRequest request) {

        logger.info(formatLog(request, id));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "操作";
        try {
            boolean value = userService.isActive(id, false);
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
     * 删除 禁用
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/remove")
    public Map<String, Object> remove(String uid, HttpServletRequest request) {
        logger.info(formatLog(request, uid));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "操作";
        try {
            boolean value = userService.delete(uid);
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
    public Map<String, Object> updpwd(String workId, String newPassword, HttpServletRequest request) {
        logger.info(formatLog(request, workId+", "+newPassword));
        Map<String, Object> result = new HashMap<String, Object>();
        try {

            if (StringUtils.isNotBlank(workId) && StringUtils.isNotBlank(newPassword)) {
                boolean value = userService.resetPassword(workId, newPassword);
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

    @ResponseBody
    @RequestMapping("/editFlag")
    public Map<String, Object> editFlag(String suId, Integer flag, HttpServletRequest request) {
        logger.info(formatLog(request, suId+", "+flag));
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isNotBlank(suId) && flag != null) {
                userService.isActive(suId, flag == 1);
                map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                map.put(HttpCode.HTTP_MSG_KEY, "操作成功");
            } else {
                map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                map.put(HttpCode.HTTP_MSG_KEY, HttpCode.HTTP_MSG_400);
            }
        } catch (Exception e) {
            map.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            map.put(HttpCode.HTTP_MSG_KEY, "操作失败,服务器错误");
        }
        return map;
    }

}
