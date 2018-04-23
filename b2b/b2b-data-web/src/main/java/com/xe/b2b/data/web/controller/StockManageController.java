package com.xe.b2b.data.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xe.b2b.data.access.model.GoodsEntity;
import com.xe.b2b.data.access.model.GoodsStockEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IGoodsService;
import com.xe.b2b.data.business.service.IGoodsStockService;
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

/**
 * 库存管理
 * 
 */
@Controller
@RequestMapping("/stockmanage")
public class StockManageController extends BaseController {

    private static final Logger logger = LogManager.getLogger(StockManageController.class);

    @Resource
    private IGoodsStockService goodsStockService;
    @Resource
    private IGoodsService goodsService;

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
        return "stockmanage/stock_add";
    }

    @RequestMapping("/stockadd")
    public String stockadd(HttpServletRequest request, @RequestParam(value = "goodsNumber") String goodsNumber,
            ModelMap map) {
        logger.info(formatLog(request, goodsNumber));
        GoodsStockEntity stock = new GoodsStockEntity();
        stock.setGoodsNumber(goodsNumber);
        map.put("stock", stock);

        return "stockmanage/stock_add";
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
            @RequestParam(value = "batchNumber", defaultValue = "") String batchNumber, ModelMap map) {
        try {
            Page<GoodsStockEntity> page = new Page<GoodsStockEntity>();
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            if (StringUtils.isNotBlank(goodsNumber)) {
                page.getParams().put("goodsNumber", goodsNumber);
            }
            if (StringUtils.isNotBlank(batchNumber)) {
                page.getParams().put("batchNumber", batchNumber);
            }

            logger.info(formatLog(request, page));
            List<GoodsStockEntity> stocks = goodsStockService.queryByPage(page);
            if (CollectionUtils.isNotEmpty(stocks)) {
                map.put("stocks", stocks);
            }
            page.setResults(stocks);

            map.put("goodsNumber", goodsNumber);
            map.put("batchNumber", batchNumber);
            map.put("page", page);
            map.put("code", HttpCode.HTTP_CODE_200);
            map.put("msg", "初始化后台用户成功");
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "stockmanage/stock_list";
    }

    /**
     * 添加或者更新
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addorupdate(HttpServletRequest request, GoodsStockEntity stock) {
        logger.info(formatLog(request, stock));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "添加";
        boolean value = false;
        if (StringUtils.isNotBlank(stock.getBatchNumber())) {
            GoodsStockEntity old = goodsStockService.get(stock.getBatchNumber());
            if (old != null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "入库批号已经存在，请更改！");
                return result;
            }
        }
        if (StringUtils.isNotBlank(stock.getGoodsNumber())) {
            GoodsEntity old = goodsService.get(stock.getGoodsNumber());
            if (old == null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "商品编号不存在，请更改！");
                return result;
            }
        } else {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "商品编号不能位空，请填写！");
            return result;
        }
        UserEntity currentUser = getcurrentUser(request);
        stock.setCreatedBy(currentUser.getWorkId());
        stock.setUpdatedBy(currentUser.getWorkId());
        value = goodsStockService.insert(stock);

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

    @ResponseBody
    @RequestMapping("/editFlag")
    public Map<String, Object> editFlag(String suId, Integer flag, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();

        logger.info(formatLog(request, suId+", "+ flag));
        try {
            if (StringUtils.isNotBlank(suId) && flag != null) {
                goodsStockService.isActive(suId, flag == 1);
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
