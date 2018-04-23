package com.xe.b2b.data.web.controller;

import com.xe.b2b.data.access.model.OrderPriceEntity;
import com.xe.b2b.data.access.model.OrderReasonEntity;
import com.xe.b2b.data.access.model.OrderReportEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IExpressService;
import com.xe.b2b.data.business.service.IOrderPriceService;
import com.xe.b2b.data.business.service.IOrderReportService;
import com.xe.b2b.data.business.service.ISystemService;
import com.xe.b2b.data.common.contants.HttpCode;
import com.xe.b2b.data.common.util.Page;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reportmanage")
public class ReportManageController extends BaseController {
	@Resource
	private IOrderReportService orderReportService;
    @Resource
    private IOrderPriceService orderPriceService;
    @Resource
    private ISystemService systemService;
	@Resource
	private IExpressService expressService;
	
	private static final Logger logger = LogManager.getLogger(ReportManageController.class);

	@RequestMapping("/reportbyworker")
	public String reportbyworker(
			HttpServletRequest request,
			ModelMap map) {
		return "reportmanage/worker_report";
	}
   @RequestMapping("/reportbydept")
    public String querydeptbypage(
            HttpServletRequest request,
            ModelMap map) {

        return "reportmanage/dept_report";
    }

	@RequestMapping("/reportbyteam")
	public String queryteambypage(
			HttpServletRequest request,
			ModelMap map) {

		return "reportmanage/team_report";
	}
	
	@RequestMapping(value = "/loadreportbyworker", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loadreportbyworker (
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate,
			HttpServletRequest request,
			ModelMap map) {
        Map<String, Object> result = new HashMap<String, Object>();
		try {
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			UserEntity currentUser = getcurrentUser(request);
			String parentCode = currentUser.getWorkId();
			Page<OrderReportEntity> page = new Page<OrderReportEntity>();
            if (StringUtils.isNotBlank(startDate)) {
                page.getParams().put("startDate", startDate);
            }
            if (StringUtils.isNotBlank(endDate)) {
                page.getParams().put("endDate", endDate);
            }
            List<OrderReportEntity> orderReports = new ArrayList<OrderReportEntity>();
            List<String> roles = currentUser.getRoleCodes();
            if (CollectionUtils.isNotEmpty(roles) && roles.contains("CEO")) {
                orderReports =  orderReportService.getOrderReportByDept(page);
            }else{
                orderReports =  orderReportService.getOrderReportByParentWorkId(parentCode, page);
            }
            if(CollectionUtils.isEmpty(orderReports)){
                orderReports = new ArrayList<OrderReportEntity>();
            }
    		result.put("orderReports", orderReports);
        	result.put("code", HttpCode.HTTP_CODE_200);
		} catch (Exception e) {
			result.put("code", HttpCode.HTTP_CODE_500);
			result.put("msg", "服务器错误！");
			logger.error("服务器错误", e);
		}
		return result;
	}

    @RequestMapping(value = "/loadreportbydept", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loadreportbydept (
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate,
            HttpServletRequest request,
            ModelMap map) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            map.put("startDate", startDate);
            map.put("endDate", endDate);
            UserEntity currentUser = getcurrentUser(request);
            String parentCode = currentUser.getWorkId();
            Page<OrderReportEntity> page = new Page<OrderReportEntity>();
            if (StringUtils.isNotBlank(startDate)) {
                page.getParams().put("startDate", startDate);
            }
            if (StringUtils.isNotBlank(endDate)) {
                page.getParams().put("endDate", endDate);
            }
            List<OrderReportEntity> orderReports = new ArrayList<OrderReportEntity>();
            List<String> roles = currentUser.getRoleCodes();
            if (CollectionUtils.isNotEmpty(roles) && roles.contains("CEO")) {
                orderReports =  orderReportService.getOrderReportByDept(page);
            }else{
                orderReports =  orderReportService.getOrderReportByParentWorkId(parentCode, page);
            }
            if(CollectionUtils.isEmpty(orderReports)){
                orderReports = new ArrayList<OrderReportEntity>();
            }
            result.put("orderReports", orderReports);
            result.put("code", HttpCode.HTTP_CODE_200);
        } catch (Exception e) {
            result.put("code", HttpCode.HTTP_CODE_500);
            result.put("msg", "服务器错误！");
            logger.error("服务器错误", e);
        }
        return result;
    }

	@RequestMapping(value = "/loadreportbyteam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loadreportbyteam (
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate,
			HttpServletRequest request,
			ModelMap map) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			UserEntity currentUser = getcurrentUser(request);
			String parentCode = currentUser.getDeptCode();
            Page<OrderReportEntity> page = new Page<OrderReportEntity>();
            if (StringUtils.isNotBlank(startDate)) {
                page.getParams().put("startDate", startDate);
            }
            if (StringUtils.isNotBlank(endDate)) {
                page.getParams().put("endDate", endDate);
            }
            List<OrderReportEntity> orderReports = new ArrayList<OrderReportEntity>();
            List<String> roles = currentUser.getRoleCodes();
            if (CollectionUtils.isNotEmpty(roles) && roles.contains("CEO")) {
                orderReports =  orderReportService.getOrderReportByDeptTeam(page);
            }else{
                orderReports =  orderReportService.getOrderReportByDeptCode(parentCode, page);
            }
        	if(CollectionUtils.isEmpty(orderReports)){
        		orderReports = new ArrayList<OrderReportEntity>();
        	}
    		result.put("orderReports", orderReports);
        	result.put("code", HttpCode.HTTP_CODE_200);
		} catch (Exception e) {
			result.put("code", HttpCode.HTTP_CODE_500);
			result.put("msg", "服务器错误！");
			logger.error("服务器错误", e);
		}
		return result;
	}

	   @RequestMapping("/orderpricelist")
	    public String orderpricelist (
	            HttpServletRequest request,
	            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
	            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
	            @RequestParam(value = "reasonName", defaultValue = "") String reasonName,
	            @RequestParam(value = "startDate", defaultValue = "") String startDate,
	            @RequestParam(value = "endDate", defaultValue = "") String endDate,
	            ModelMap map) {
	        try {
	            map.put("startDate", startDate);
	            map.put("endDate", endDate);
	            map.put("reasonName", reasonName);
	            Page<OrderPriceEntity> page = new Page<OrderPriceEntity>();
	            page.setPageNo(pageNo);
	            page.setPageSize(pageSize);
               if (StringUtils.isNotBlank(reasonName)) {
                    page.getParams().put("reasonName", reasonName);
                }
	            if (StringUtils.isNotBlank(startDate)) {
	                page.getParams().put("startDate", startDate);
	            }
	            if (StringUtils.isNotBlank(endDate)) {
	                page.getParams().put("endDate", endDate);
	            }
	            List<OrderReasonEntity> reasonList = systemService.getOrderReasons();
	            if (CollectionUtils.isNotEmpty(reasonList)) {
	                map.put("reasons", reasonList);
	            }
	            List<OrderPriceEntity> orderPrices =  orderPriceService.queryByPage(page);
	            if(CollectionUtils.isEmpty(orderPrices)){
	                orderPrices = new ArrayList<OrderPriceEntity>();
	            }

	            page.setResults(orderPrices);
	            map.put("orderPrices", orderPrices);
	            map.put("page", page);
	            map.put("code", HttpCode.HTTP_CODE_200);
	        } catch (Exception e) {
	            map.put("code", HttpCode.HTTP_CODE_500);
	            map.put("msg", "服务器错误！");
	            logger.error("服务器错误", e);
	        }
	        return "reportmanage/order_price_list";
	    }
	   

	    @RequestMapping(value = "/priceexport", method = RequestMethod.GET)
	    public void exportOrders(Model model, HttpServletRequest request, HttpServletResponse response)
	            throws IOException {
	        String reasonName = request.getParameter("reasonName");
	        String startDate = request.getParameter("startDate");
	        String endDate = request.getParameter("endDate");
	        Page<OrderPriceEntity> page = new Page<OrderPriceEntity>();
	        page.setPageNo(1);
	        page.setPageSize(1000000);
	        if (StringUtils.isNotBlank(reasonName)) {
	            page.getParams().put("reasonName", reasonName);
	        }
	        if (StringUtils.isNotBlank(startDate)) {
	            page.getParams().put("startDate", startDate);
	        }
	        if (StringUtils.isNotBlank(endDate)) {
	            page.getParams().put("endDate", endDate);
	        }
	        byte resultByte[] = orderPriceService.exportOrder(page);
	        byte result[] = (new String(resultByte)).getBytes("utf-8");
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	        response.setHeader("Content-Disposition", "attachment;filename=order.csv");
	        response.setCharacterEncoding("utf-8");
	        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
	        out.write(new byte[] {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF,});
	        out.write(result, 0, result.length);
	        out.close();
	    }
}
