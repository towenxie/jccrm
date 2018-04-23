package com.xe.b2b.data.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import com.xe.b2b.data.access.model.GoodsEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IGoodsService;
import com.xe.b2b.data.common.contants.HttpCode;
import com.xe.b2b.data.common.util.Page;

@Controller
@RequestMapping("/goodsmanage")
public class GoodsManageController extends BaseController {
    @Resource
    private IGoodsService goodsService;

    private static final Logger logger = LogManager.getLogger(GoodsManageController.class);

    /**
     * 编辑更新初始化
     * 
     * @param request
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/updateInit")
    public String updateInit(HttpServletRequest request, @RequestParam(value = "goodsNumber") String goodsNumber,
            ModelMap map) {

        logger.info(formatLog(request, goodsNumber));
        if (StringUtils.isNotBlank(goodsNumber)) {
            GoodsEntity goods = goodsService.get(goodsNumber);
            if (goods != null) {
                map.put("goods", goods);
            }
        }


        return "goodsmanage/goods_editinfo";
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
        GoodsEntity goodsModel = goodsService.get(id);
        if (goodsModel != null) {
            map.put("goods", goodsModel);
        }
        return "goodsmanage/goods_info";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, GoodsEntity goods) {
        logger.info(formatLog(request, goods));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "更新";
        UserEntity currentUser = getcurrentUser(request);
        goods.setUpdatedBy(currentUser.getWorkId());

        try {
            boolean value = goodsService.update(goods);
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
        return "goodsmanage/add";
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
            @RequestParam(value = "goodsNumber", defaultValue = "") String goodsNumber,
            @RequestParam(value = "name", defaultValue = "") String name, ModelMap map) {
        try {
            Page<GoodsEntity> page = new Page<GoodsEntity>();
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            if (StringUtils.isNotBlank(goodsNumber)) {
                page.getParams().put("goodsNumber", goodsNumber);
            }
            if (StringUtils.isNotBlank(name)) {
                page.getParams().put("name", name);
            }
            logger.info(formatLog(request, page));
            List<GoodsEntity> goods = goodsService.queryByPage(page);
            if (CollectionUtils.isNotEmpty(goods)) {
                map.put("users", goods);
            }
            page.setResults(goods);

            map.put("goodsNumber", goodsNumber);
            map.put("name", name);
            map.put("page", page);
            map.put("code", HttpCode.HTTP_CODE_200);
            map.put("msg", "初始化后台用户成功");
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "goodsmanage/goods_list";
    }

    /**
     * 添加或者更新
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addorupdate(HttpServletRequest request, GoodsEntity goods) {
        logger.info(formatLog(request, goods));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "添加";
        boolean value = false;
        Long id = goods.getId();

        UserEntity currentUser = getcurrentUser(request);
        goods.setCreatedBy(currentUser.getWorkId());
        goods.setUpdatedBy(currentUser.getWorkId());
        if (id != null && id != 0) {
            msg = "更新";
            value = goodsService.update(goods);
        } else {
            if (StringUtils.isNotBlank(goods.getGoodsNumber())) {
                GoodsEntity old = goodsService.get(goods.getGoodsNumber());
                if (old != null) {
                    result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                    result.put(HttpCode.HTTP_MSG_KEY, "商品编号已经存在，请更改！");
                    return result;
                }
            }
            value = goodsService.insert(goods);
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
            boolean value = goodsService.isActive(id, false);
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
    @RequestMapping("/editFlag")
    public Map<String, Object> editFlag(String suId, Integer flag, HttpServletRequest request) {
        logger.info(formatLog(request, suId+", "+flag));
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isNotBlank(suId) && flag != null) {
                goodsService.isActive(suId, flag == 1);
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

    @ResponseBody
    @RequestMapping("/remove")
    public Map<String, Object> remove(String uid, HttpServletRequest request) {
        logger.info(formatLog(request, uid));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "操作";
        try {
            boolean value = goodsService.delete(uid);
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
}
