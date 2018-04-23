package com.xe.b2b.data.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xe.b2b.data.access.model.GoodsEntity;
import com.xe.b2b.data.access.model.GoodsStockEntity;
import com.xe.b2b.data.access.model.GoodsStockLogEntity;
import com.xe.b2b.data.access.model.StockTypeEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IGoodsService;
import com.xe.b2b.data.business.service.IGoodsStockLogService;
import com.xe.b2b.data.business.service.IGoodsStockService;
import com.xe.b2b.data.business.service.ISystemService;
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
 * 库存清单管理
 * 
 */
@Controller
@RequestMapping("/stocklogmanage")
public class StockLogManageController extends BaseController {

	private static final Logger logger = LogManager
			.getLogger(StockLogManageController.class);

	@Resource
	private IGoodsStockLogService goodsStockLogService;
    @Resource
    private IGoodsStockService goodsStockService;
    @Resource
    private IGoodsService goodsService;


	@Resource
	private ISystemService systemService;
	
	/**
	 * 根据ID查询用户详情
	 * 
	 * @param request
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/details")
	public String details(HttpServletRequest request,
			@RequestParam(value = "id") String id, ModelMap map) {
	    logger.info(formatLog(request, id));
		GoodsStockLogEntity stock = goodsStockLogService.get(id);
		if (stock != null) {
			map.put("stock", stock);
		}
		return "stocklogmanage/stock_log_info";
	}

	@RequestMapping("/stockedit")
	public String stockedit(HttpServletRequest request,
			@RequestParam(value = "batchNumber") String batchNumber,
			@RequestParam(value = "goodsNumber") String goodsNumber,
			ModelMap map) {

        logger.info(formatLog(request, batchNumber+","+goodsNumber));
		GoodsStockLogEntity stock = new GoodsStockLogEntity();
		stock.setBatchNumber(batchNumber);
		stock.setGoodsNumber(goodsNumber);
		map.put("stock", stock);
		List<StockTypeEntity> types = systemService.selectAllStockType();
		if (CollectionUtils.isNotEmpty(types)) {
			map.put("types", types);
		}
		return "stocklogmanage/stock_log_add";
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
		List<StockTypeEntity> types = systemService.selectAllStockType();
		if (CollectionUtils.isNotEmpty(types)) {
			map.put("types", types);
		}
		return "stocklogmanage/stock_log_add";
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
	public String querybypage(
			HttpServletRequest request,
			@RequestParam(defaultValue = "1", required = false) Integer pageNo,
			@RequestParam(defaultValue = "20", required = false) Integer pageSize,
			@RequestParam(value = "goodsNumber", defaultValue = "") String goodsNumber,
			@RequestParam(value = "batchNumber", defaultValue = "") String batchNumber,
			@RequestParam(value = "stockCode", defaultValue = "") String stockCode,
			ModelMap map) {
		try {
			Page<GoodsStockLogEntity> page = new Page<GoodsStockLogEntity>();
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			if (StringUtils.isNotBlank(goodsNumber)) {
				page.getParams().put("goodsNumber", goodsNumber);
			}
			if (StringUtils.isNotBlank(batchNumber)) {
				page.getParams().put("batchNumber", batchNumber);
			}
			if (StringUtils.isNotBlank(stockCode)) {
				page.getParams().put("stockCode", stockCode);
			}
			logger.info(formatLog(request, page));
			List<GoodsStockLogEntity> stocks = goodsStockLogService
					.queryByPage(page);
			if (CollectionUtils.isNotEmpty(stocks)) {
				map.put("stocks", stocks);
			}
			List<StockTypeEntity> types = systemService
					.selectAllStockType();
			if (CollectionUtils.isNotEmpty(types)) {
				map.put("types", types);
			}
			page.setResults(stocks);

			map.put("goodsNumber", goodsNumber);
			map.put("batchNumber", batchNumber);
			map.put("stockCode", stockCode);
			map.put("page", page);
			map.put("code", HttpCode.HTTP_CODE_200);
			map.put("msg", "初始化后台用户成功");
		} catch (Exception e) {
			map.put("code", HttpCode.HTTP_CODE_500);
			map.put("msg", "分页列表初始化失败！");
			logger.error("分页列表初始化失败", e);
		}
		return "stocklogmanage/stock_log_list";
	}

	/**
	 * 添加或者更新
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addorupdate(HttpServletRequest request,
			GoodsStockLogEntity stock) {
        logger.info(formatLog(request, stock));
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "添加";
		boolean value = false;
		
        if (StringUtils.isNotBlank(stock.getBatchNumber())) {
            GoodsStockEntity old = goodsStockService.get(stock.getBatchNumber());
            if (old == null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "商品批号不存在，请更改！");
                return result;
            }
        } else {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "商品批号不能为空，请填写！");
            return result;
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
		value = goodsStockLogService.insert(stock);

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
}
