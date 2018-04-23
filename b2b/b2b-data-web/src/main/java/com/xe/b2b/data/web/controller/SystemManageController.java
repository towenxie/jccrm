package com.xe.b2b.data.web.controller;

import com.xe.b2b.data.access.model.DeptEntity;
import com.xe.b2b.data.access.model.ExpressEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IDeptService;
import com.xe.b2b.data.business.service.IExpressService;
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
@RequestMapping("/systemmanage")
public class SystemManageController extends BaseController {
    @Resource
    private IDeptService deptService;

    @Resource
    private IExpressService expressService;

    private static final Logger logger = LogManager.getLogger(SystemManageController.class);

    @RequestMapping("/dept/querybypage")
    public String queryDeptbypage(HttpServletRequest request,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
            @RequestParam(value = "deptName", defaultValue = "") String deptName, ModelMap map) {
        try {
            Page<DeptEntity> page = new Page<DeptEntity>();
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            List<DeptEntity> deptParents = deptService.selectAllParent();
            if (CollectionUtils.isNotEmpty(deptParents)) {
                map.put("deptParents", deptParents);
            }
            if (StringUtils.isNotBlank(deptName)) {
                page.getParams().put("deptName", deptName);
            }
            logger.info(formatLog(request, page));
            List<DeptEntity> depts = deptService.queryByPage(page);
            if (CollectionUtils.isNotEmpty(depts)) {
                map.put("depts", depts);
            }
            page.setResults(depts);

            map.put("deptName", deptName);
            map.put("page", page);
            map.put("code", HttpCode.HTTP_CODE_200);
            map.put("msg", "初始化科室列表成功");
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "systemmanage/dept_list";
    }

    /**
     * 修改密码
     * 
     * @param id
     * @param pwd
     * @param request
     * @return
     */
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deptadd(String deptCode, String parentCode, String deptName, Integer canSale,
            HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            logger.info(formatLog(request, deptCode + "," + parentCode + "," + deptName + "," + canSale));
            DeptEntity old = deptService.get(deptCode);
            if (old != null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, "科室代码 不能重复！");
                return result;
            }
            DeptEntity dept = new DeptEntity();
            dept.setCode(deptCode);
            dept.setName(deptName);
            dept.setCanSale(canSale == 1);
            if (StringUtils.isBlank(parentCode)) {
                dept.setParentCode(deptCode);
            } else {
                dept.setParentCode(parentCode);
            }
            UserEntity currentUser = getcurrentUser(request);
            dept.setCreatedBy(currentUser.getWorkId());
            dept.setUpdatedBy(currentUser.getWorkId());
            boolean value = deptService.insert(dept);
            if (value) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                result.put(HttpCode.HTTP_MSG_KEY, "添加科室成功！");
            } else {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, "添加科室错误！");
            }
        } catch (Exception e) {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "添加科室错误！");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/dept/remove")
    public Map<String, Object> remove(String uid, HttpServletRequest request) {
        logger.info(formatLog(request, uid));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "操作";
        try {
            boolean value = deptService.delete(uid);
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

    @ResponseBody
    @RequestMapping("/dept/editFlag")
    public Map<String, Object> editdeptFlag(String suId, Integer flag, HttpServletRequest request) {
        logger.info(formatLog(request, suId + "," + flag));
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isNotBlank(suId) && flag != null) {
                deptService.isActive(suId, flag == 1);
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


    @RequestMapping("/express/querybypage")
    public String queryExpressbypage(HttpServletRequest request,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
            @RequestParam(value = "expressName", defaultValue = "") String expressName, ModelMap map) {
        try {
            Page<ExpressEntity> page = new Page<ExpressEntity>();
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            if (StringUtils.isNotBlank(expressName)) {
                page.getParams().put("expressName", expressName);
            }
            logger.info(formatLog(request, page));
            List<ExpressEntity> express = expressService.queryByPage(page);
            if (CollectionUtils.isNotEmpty(express)) {
                map.put("express", express);
            }
            page.setResults(express);

            map.put("expressName", expressName);
            map.put("page", page);
            map.put("code", HttpCode.HTTP_CODE_200);
            map.put("msg", "初始化科室列表成功");
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "systemmanage/express_list";
    }

    @RequestMapping(value = "/express/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> expressadd(String expressCode, String expressName, String expressLink,
            HttpServletRequest request) {

        logger.info(formatLog(request, expressCode + "," + expressName + "," + expressLink));
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            ExpressEntity old = expressService.get(expressCode);
            if (old != null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, "快递代码 不能重复！");
                return result;
            }
            ExpressEntity express = new ExpressEntity();
            express.setCode(expressCode);
            express.setName(expressName);
            express.setLink(expressLink);
            UserEntity currentUser = getcurrentUser(request);
            express.setCreatedBy(currentUser.getWorkId());
            express.setUpdatedBy(currentUser.getWorkId());
            boolean value = expressService.insert(express);
            if (value) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                result.put(HttpCode.HTTP_MSG_KEY, "添加快递成功！");
            } else {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, "添加快递错误！");
            }
        } catch (Exception e) {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "添加快递错误！");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/express/editFlag")
    public Map<String, Object> editexpressFlag(String suId, Integer flag, HttpServletRequest request) {
        logger.info(formatLog(request, suId + "," + flag));
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isNotBlank(suId) && flag != null) {
                expressService.isActive(suId, flag == 1);
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
