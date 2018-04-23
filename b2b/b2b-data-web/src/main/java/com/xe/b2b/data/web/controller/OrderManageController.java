package com.xe.b2b.data.web.controller;

import com.xe.b2b.data.access.model.DeptEntity;
import com.xe.b2b.data.access.model.ExpressEntity;
import com.xe.b2b.data.access.model.GoodsEntity;
import com.xe.b2b.data.access.model.OrderEntity;
import com.xe.b2b.data.access.model.OrderPriceEntity;
import com.xe.b2b.data.access.model.OrderReasonEntity;
import com.xe.b2b.data.access.model.OrderStatusEntity;
import com.xe.b2b.data.access.model.PaymentEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.business.service.IDeptService;
import com.xe.b2b.data.business.service.IGoodsService;
import com.xe.b2b.data.business.service.IOrderPriceService;
import com.xe.b2b.data.business.service.IOrderService;
import com.xe.b2b.data.business.service.ISystemService;
import com.xe.b2b.data.business.service.IUserService;
import com.xe.b2b.data.common.contants.HttpCode;
import com.xe.b2b.data.common.util.Page;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/ordermanage")
public class OrderManageController extends BaseController {
    @Resource
    private IOrderService orderService;
    @Resource
    private IOrderPriceService orderPriceService;
    @Resource
    private IDeptService deptService;
    @Resource
    private IUserService userService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private ISystemService systemService;

    private static final Logger logger = LogManager.getLogger(OrderManageController.class);

    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, @RequestParam(value = "orderNum") String orderNum,
            ModelMap map) {
        logger.info(formatLog(request, orderNum));
        OrderEntity order = orderService.get(orderNum);
        map.put("order", order);

        return "ordermanage/order_info";
    }
    
    @RequestMapping("/financeorder/orderpriceinit")
    public String orderpriceinit(HttpServletRequest request, @RequestParam(value = "orderNum") String orderNum,
            ModelMap map) {
        logger.info(formatLog(request, orderNum));
        OrderPriceEntity orderPrice = orderPriceService.get(orderNum);
        map.put("orderPrice", orderPrice);
        List<OrderReasonEntity> reasonList = systemService.getOrderReasons();
        if (CollectionUtils.isNotEmpty(reasonList)) {
            map.put("reasons", reasonList);
        }

        return "ordermanage/financeorder/order_price_update";
    }
    @RequestMapping(value = "/financeorder/orderpriceupdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> orderpriceupdate(HttpServletRequest request, OrderPriceEntity orderPrice) {
        logger.info(formatLog(request, orderPrice));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "更新";
        UserEntity currentUser = getcurrentUser(request);
        orderPrice.setUpdatedBy(currentUser.getWorkId());

        try {
            boolean value = orderPriceService.update(orderPrice);
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
    @RequestMapping("/myorder/updateinit")
    public String updateMyInit(HttpServletRequest request, @RequestParam(value = "orderNum") String orderNum,
            ModelMap map) {
        logger.info(formatLog(request, orderNum));
        OrderEntity order = orderService.get(orderNum);
        map.put("order", order);
        List<OrderStatusEntity> statusList = systemService.getOrderStatus();
        List<OrderStatusEntity> status = new ArrayList<OrderStatusEntity>();
        if ("pending".equals(order.getOrderStatus().getCode()) || "paid".equals(order.getOrderStatus().getCode())) {
            status.add(order.getOrderStatus());
        } else {
            for (OrderStatusEntity model : statusList) {
                if (order.getOrderStatus().getId() <= model.getId()) {
                    status.add(model);
                }
            }
        }
        if (CollectionUtils.isNotEmpty(status)) {
            map.put("status", status);
        }

        return "ordermanage/myorder/my_order_update";
    }

    @RequestMapping("/packageorder/info")
    public String packageorderInfo(HttpServletRequest request, @RequestParam(value = "orderNum") String orderNum,
            ModelMap map) {
        logger.info(formatLog(request, orderNum));
        OrderEntity order = orderService.get(orderNum);
        List<OrderEntity> orders = new ArrayList<OrderEntity>();
        orders.add(order);
        map.put("orders", orders);

        return "ordermanage/packageorder/package_order_info";
    }

    @RequestMapping("/financeorder/updateinit")
    public String updateFinanceInit(HttpServletRequest request, @RequestParam(value = "orderNum") String orderNum,
            ModelMap map) {
        logger.info(formatLog(request, orderNum));
        OrderEntity order = orderService.get(orderNum);
        List<OrderStatusEntity> status = systemService.getOrderStatus();
        map.put("order", order);

        List<OrderStatusEntity> statusList = systemService.getOrderStatus();
        if ("pending".equals(order.getOrderStatus().getCode())) {
            status.add(order.getOrderStatus());
        }

        for (OrderStatusEntity model : statusList) {
            if ("paid".equals(model.getCode())) {
                status.add(model);
            }
        }

        if (CollectionUtils.isNotEmpty(status)) {
            map.put("status", status);
        }
        List<PaymentEntity> payments = systemService.getPayments();
        if (CollectionUtils.isNotEmpty(payments)) {
            map.put("payments", payments);
        }

        return "ordermanage/financeorder/finance_order_update";
    }

    @RequestMapping("/packageorder/updateinit")
    public String updatePackageInit(HttpServletRequest request, @RequestParam(value = "orderNum") String orderNum,
            ModelMap map) {
        logger.info(formatLog(request, orderNum));
        OrderEntity order = orderService.get(orderNum);
        List<OrderStatusEntity> status = systemService.getOrderStatus();
        map.put("order", order);

        List<OrderStatusEntity> statusList = systemService.getOrderStatus();
        if ("paid".equals(order.getOrderStatus().getCode())) {
            status.add(order.getOrderStatus());
        }

        for (OrderStatusEntity model : statusList) {
            if ("shipped".equals(model.getCode())) {
                status.add(model);
            }
        }

        if (CollectionUtils.isNotEmpty(status)) {
            map.put("status", status);
        }
        List<ExpressEntity> express = systemService.getAllExpress();
        if (CollectionUtils.isNotEmpty(express)) {
            map.put("express", express);
        }
        return "ordermanage/packageorder/package_order_update";
    }

    @RequestMapping("/myorder/addinit")
    public String addinit(HttpServletRequest request, ModelMap map) {
        logger.info(formatLog(request, ""));
        List<DeptEntity> depts = deptService.selectDeptAll();
        if (CollectionUtils.isNotEmpty(depts)) {
            map.put("depts", depts);
        }

        List<OrderStatusEntity> status = systemService.getOrderStatus();
        if (CollectionUtils.isNotEmpty(status)) {
            map.put("status", status);
        }

        List<PaymentEntity> payments = systemService.getPayments();
        if (CollectionUtils.isNotEmpty(payments)) {
            map.put("payments", payments);
        }

        List<ExpressEntity> express = systemService.getAllExpress();
        if (CollectionUtils.isNotEmpty(express)) {
            map.put("express", express);
        }

        List<GoodsEntity> goods = goodsService.getAllGoods();
        if (CollectionUtils.isNotEmpty(goods)) {
            map.put("goods", goods);
        }

        return "ordermanage/myorder/my_order_add";
    }

    @RequestMapping("/myorder/appaddinit")
    public String appAddinit(HttpServletRequest request, ModelMap map) {
        logger.info(formatLog(request, ""));
        List<DeptEntity> depts = deptService.selectDeptAll();
        if (CollectionUtils.isNotEmpty(depts)) {
            map.put("depts", depts);
        }

        List<OrderStatusEntity> status = systemService.getOrderStatus();
        if (CollectionUtils.isNotEmpty(status)) {
            map.put("status", status);
        }

        List<PaymentEntity> payments = systemService.getPayments();
        if (CollectionUtils.isNotEmpty(payments)) {
            map.put("payments", payments);
        }

        List<ExpressEntity> express = systemService.getAllExpress();
        if (CollectionUtils.isNotEmpty(express)) {
            map.put("express", express);
        }

        List<GoodsEntity> goods = goodsService.getAllGoods();
        if (CollectionUtils.isNotEmpty(goods)) {
            map.put("goods", goods);
        }

        return "ordermanage/myorder/app_order_add";
    }

    @RequestMapping("/myorder/querybypage")
    public String querymyorderbypage(HttpServletRequest request,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
            @RequestParam(value = "customer", defaultValue = "") String customer,
            @RequestParam(value = "orderNumber", defaultValue = "") String orderNumber,
            @RequestParam(value = "orderPayment", defaultValue = "") String orderPayment,
            @RequestParam(value = "orderStatus", defaultValue = "") String orderStatus,
            @RequestParam(value = "expressNumber", defaultValue = "") String expressNumber,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "orderDept", defaultValue = "") String orderDept, ModelMap map) {
        try {

            Page<OrderEntity> page = new Page<OrderEntity>();
            UserEntity currentUser = getcurrentUser(request);
            String createdById = currentUser.getWorkId();
            if (StringUtils.isNotBlank(createdById)) {
                page.getParams().put("createdById", createdById);
            }
            initQueryOrderByPage(page, pageNo, pageSize, orderNumber, orderPayment, orderStatus, orderDept, expressNumber, startDate,
                    endDate, customer, "", map);
            logger.info(formatLog(request, page));
            List<OrderEntity> myorders = orderService.queryByPage(page);
            if (CollectionUtils.isNotEmpty(myorders)) {
                map.put("myorders", myorders);
            }
            page.setResults(myorders);
            Float totalPrice = orderService.getTotalPriceByPage(page);
            if (totalPrice == null) {
                totalPrice = 0f;
            }
            map.put("totalPrice", totalPrice);
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "ordermanage/myorder/my_order_list";
    }

    @RequestMapping("/suborder/querybypage")
    public String querysuborderbypage(HttpServletRequest request,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
            @RequestParam(value = "createdBy", defaultValue = "") String createdBy,
            @RequestParam(value = "customer", defaultValue = "") String customer,
            @RequestParam(value = "orderNumber", defaultValue = "") String orderNumber,
            @RequestParam(value = "orderPayment", defaultValue = "") String orderPayment,
            @RequestParam(value = "expressNumber", defaultValue = "") String expressNumber,
            @RequestParam(value = "orderStatus", defaultValue = "") String orderStatus,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "orderDept", defaultValue = "") String orderDept, ModelMap map) {
        try {

            Page<OrderEntity> page = new Page<OrderEntity>();
            UserEntity currentUser = getcurrentUser(request);
            page.getParams().put("parent", currentUser.getWorkId());

            initQueryOrderByPage(page, pageNo, pageSize, orderNumber, orderPayment, orderStatus, orderDept, expressNumber,startDate,
                    endDate, customer, createdBy, map);
//            List<DeptEntity> depts = deptService.selectDeptAll();
//            if (CollectionUtils.isNotEmpty(depts)) {
//                map.put("depts", depts);
//            }

            logger.info(formatLog(request, page));
            List<OrderEntity> suborders = orderService.queryByPage(page);

            page.setResults(suborders);
            Float totalPrice = orderService.getTotalPriceByPage(page);
            if (totalPrice == null) {
                totalPrice = 0f;
            }
            map.put("totalPrice", totalPrice);
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "ordermanage/suborder/sub_order_list";
    }

    @RequestMapping("/financeorder/querybypage")
    public String queryfinanceorderbypage(HttpServletRequest request,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
            @RequestParam(value = "createdBy", defaultValue = "") String createdBy,
            @RequestParam(value = "customer", defaultValue = "") String customer,
            @RequestParam(value = "orderNumber", defaultValue = "") String orderNumber,
            @RequestParam(value = "orderPayment", defaultValue = "") String orderPayment,
            @RequestParam(value = "orderStatus", defaultValue = "") String orderStatus,
            @RequestParam(value = "expressNumber", defaultValue = "") String expressNumber,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "orderDept", defaultValue = "") String orderDept, ModelMap map) {
        try {

            Page<OrderEntity> page = new Page<OrderEntity>();
            UserEntity currentUser = getcurrentUser(request);
            List<String> roles = currentUser.getRoleCodes();
            if (CollectionUtils.isNotEmpty(roles)) {
                map.put("canDelete", roles.contains("CFO") || roles.contains("CEO"));
            }else{
                map.put("canDelete", false);
            }
            
            initQueryOrderByPage(page, pageNo, pageSize, orderNumber, orderPayment, orderStatus, orderDept, expressNumber, startDate,
                    endDate, customer, createdBy, map);

            logger.info(formatLog(request, page));
            List<OrderEntity> saleorders = orderService.queryByPage(page);
            page.setResults(saleorders);
            Float totalPrice = orderService.getTotalPriceByPage(page);
            if (totalPrice == null) {
                totalPrice = 0f;
            }
            map.put("totalPrice", totalPrice);
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "ordermanage/financeorder/finance_order_list";
    }


    @RequestMapping("/packageorder/querybypage")
    public String querypackageorderbypage(HttpServletRequest request,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "20", required = false) Integer pageSize,
            @RequestParam(value = "createdBy", defaultValue = "") String createdBy,
            @RequestParam(value = "customer", defaultValue = "") String customer,
            @RequestParam(value = "orderNumber", defaultValue = "") String orderNumber,
            @RequestParam(value = "orderPayment", defaultValue = "") String orderPayment,
            @RequestParam(value = "orderStatus", defaultValue = "") String orderStatus,
            @RequestParam(value = "expressNumber", defaultValue = "") String expressNumber,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "orderDept", defaultValue = "", required = false) String orderDept, ModelMap map) {
        try {

            Page<OrderEntity> page = new Page<OrderEntity>();
            page.getParams().put("canSend", true);
            initQueryOrderByPage(page, pageNo, pageSize, orderNumber, orderPayment, orderStatus, orderDept, expressNumber, startDate,
                    endDate, customer, createdBy, map);
            logger.info(formatLog(request, page));
            List<OrderEntity> saleorders = orderService.queryByPage(page);
            page.setResults(saleorders);
            Float totalPrice = orderService.getTotalPriceByPage(page);
            if (totalPrice == null) {
                totalPrice = 0f;
            }
            map.put("totalPrice", totalPrice);
        } catch (Exception e) {
            map.put("code", HttpCode.HTTP_CODE_500);
            map.put("msg", "分页列表初始化失败！");
            logger.error("分页列表初始化失败", e);
        }
        return "ordermanage/packageorder/package_order_list";
    }

    @RequestMapping(value = "/myorder/app/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> myorderappadd(@RequestBody OrderEntity order, HttpServletRequest request, ModelMap map) {
        logger.info(formatLog(request, order));
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            UserEntity currentUser = getcurrentUser(request);
            order.setDeptCode(currentUser.getDeptCode());
            order.setCreatedBy(currentUser.getWorkId());
            order.setUpdatedBy(currentUser.getWorkId());
            order.setOrderStatusCode("pending");
            Integer localhost = order.getLocationId();
            if (localhost != null) {
                order.setLocationId(localhost);
            } else if (order.getLocationId2() != null) {
                order.setLocationId(order.getLocationId2());
            } else {
                order.setLocationId(order.getLocationId1());
            }

            boolean value = orderService.insert(order);
            if (value) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                result.put(HttpCode.HTTP_MSG_KEY, "添加订单成功！");
                appAddinit(request, map);
            } else {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, "添加订单错误！");
            }
        } catch (Exception e) {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "添加订单错误！");
        }
        return result;
    }

    @RequestMapping(value = "/myorder/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> myorderadd(@RequestBody OrderEntity order, HttpServletRequest request) {

        logger.info(formatLog(request, order));
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            UserEntity currentUser = getcurrentUser(request);
            order.setDeptCode(currentUser.getDeptCode());
            order.setCreatedBy(currentUser.getWorkId());
            order.setUpdatedBy(currentUser.getWorkId());
            order.setOrderStatusCode("pending");
            Integer localhost = order.getLocationId();
            if (localhost != null) {
                order.setLocationId(localhost);
            } else if (order.getLocationId2() != null) {
                order.setLocationId(order.getLocationId2());
            } else {
                order.setLocationId(order.getLocationId1());
            }

            boolean value = orderService.insert(order);
            if (value) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                result.put(HttpCode.HTTP_MSG_KEY, "添加订单成功！");
            } else {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, "添加订单错误！");
            }
        } catch (Exception e) {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "添加订单错误！");
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, OrderEntity order) {

        logger.info(formatLog(request, order));
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(order.getPackageBy())) {
            UserEntity old = userService.get(order.getPackageBy().toUpperCase());
            if (old == null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "打包人工号不存在，请更改！");
                return result;
            } else {
                order.setPackageBy(order.getPackageBy().toUpperCase());
            }
        }
        if (StringUtils.isNotBlank(order.getDeliverBy())) {
            UserEntity old = userService.get(order.getDeliverBy().toUpperCase());
            if (old == null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "录入人工号不存在，请更改！");
                return result;
            } else {
                order.setDeliverBy(order.getDeliverBy().toUpperCase());
            }
        }
        String msg = "更新";
        UserEntity currentUser = getcurrentUser(request);
        order.setUpdatedBy(currentUser.getWorkId());

        try {
            boolean value = orderService.update(order);
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

    @RequestMapping(value = "/orderupdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> packageupdate(HttpServletRequest request, OrderEntity order) {
        logger.info(formatLog(request, order));
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(order.getPackageBy())) {
            UserEntity old = userService.get(order.getPackageBy().toUpperCase());
            if (old == null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "打包人不存在，请更改！");
                return result;
            }
        }
        if (StringUtils.isNotBlank(order.getDeliverBy())) {
            UserEntity old = userService.get(order.getDeliverBy().toUpperCase());
            if (old == null) {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                result.put(HttpCode.HTTP_MSG_KEY, "录入人不存在，请更改！");
                return result;
            }
        }
        String msg = "更新";
        UserEntity currentUser = getcurrentUser(request);
        order.setUpdatedBy(currentUser.getWorkId());

        try {
            order.setOrderStatusCode(null);
            boolean value = orderService.updateWithoutStatus(order);
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
    @RequestMapping("/hasrefund")
    public Map<String, Object> hasrefund(String orderNumber, HttpServletRequest request) {
        logger.info(formatLog(request, orderNumber));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "退货签收";
        try {
            OrderEntity order = new OrderEntity();
            UserEntity currentUser = getcurrentUser(request);
            order.setUpdatedBy(currentUser.getWorkId());
            if (StringUtils.isNotBlank(orderNumber)) {
                order.setHasRund(true);
                order.setOrderNumber(orderNumber);
                boolean value = orderService.updateWithoutStatus(order);
                if (value) {
                    result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_200);
                    result.put(HttpCode.HTTP_MSG_KEY, msg + "成功！");
                } else {
                    result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
                    result.put(HttpCode.HTTP_MSG_KEY, msg + "失败！");
                }
            } else {
                result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_400);
                result.put(HttpCode.HTTP_MSG_KEY, HttpCode.HTTP_MSG_400);
            }
        } catch (Exception e) {
            result.put(HttpCode.HTTP_CODE_KEY, HttpCode.HTTP_CODE_500);
            result.put(HttpCode.HTTP_MSG_KEY, "操作失败,服务器错误");
        }
        return result;
    }

    @RequestMapping(value = "/myorder/export", method = RequestMethod.GET)
    public void exportOrders(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info(formatLog(request, ""));

        UserEntity currentUser = getcurrentUser(request);
        byte resultByte[] = orderService.exportOrdersByUser(currentUser.getWorkId());
        byte result[] = (new String(resultByte)).getBytes("utf-8");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + currentUser.getName() + "-Orders.csv");
        response.setCharacterEncoding("utf-8");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(new byte[] {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF,});
        out.write(result, 0, result.length);
        out.close();
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportFOrders(Model model, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info(formatLog(request, ""));
        String orderNumber = request.getParameter("orderNumber");
        String createdBy = request.getParameter("createdBy");
        String customer = request.getParameter("customer");
        String orderPayment = request.getParameter("orderPayment");
        String orderStatus = request.getParameter("orderStatus");
        String orderDept = request.getParameter("orderDept");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String expressNumber = request.getParameter("expressNumber");
        Page<OrderEntity> page = new Page<OrderEntity>();
        page.setPageNo(1);
        page.setPageSize(1000000);
        if (StringUtils.isNotBlank(expressNumber)) {
            page.getParams().put("expressNumber", expressNumber);
        }
        if (StringUtils.isNotBlank(createdBy)) {
            page.getParams().put("createdBy", createdBy);
        }
        if (StringUtils.isNotBlank(customer)) {
            page.getParams().put("username", customer);
        }
        if (StringUtils.isNotBlank(orderNumber)) {
            page.getParams().put("orderNumber", orderNumber);
        }
        if (StringUtils.isNotBlank(orderPayment)) {
            page.getParams().put("paymentCode", orderPayment);
        }
        if (StringUtils.isNotBlank(orderStatus)) {
            page.getParams().put("orderStatusCode", orderStatus);
        }
        if (StringUtils.isNotBlank(orderDept)) {
            page.getParams().put("deptCode", orderDept);
        }
        if (StringUtils.isNotBlank(startDate)) {
            page.getParams().put("startDate", startDate);
        }
        if (StringUtils.isNotBlank(endDate)) {
            page.getParams().put("endDate", endDate);
        }
        byte resultByte[] = orderService.exportOrder(page);
        byte result[] = (new String(resultByte)).getBytes("utf-8");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=order.csv");
        response.setCharacterEncoding("utf-8");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(new byte[] {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF,});
        out.write(result, 0, result.length);
        out.close();
    }

    @RequestMapping(value = "/packageorder/export", method = RequestMethod.GET)
    public void exportPackageOrders(Model model, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info(formatLog(request, ""));
        String orderNumber = request.getParameter("orderNumber");
        String createdBy = request.getParameter("createdBy");
        String customer = request.getParameter("customer");
        String orderPayment = request.getParameter("orderPayment");
        String orderStatus = request.getParameter("orderStatus");
        String orderDept = request.getParameter("orderDept");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String expressNumber = request.getParameter("expressNumber");
        Page<OrderEntity> page = new Page<OrderEntity>();
        page.setPageNo(1);
        page.setPageSize(1000000);
        if (StringUtils.isNotBlank(expressNumber)) {
            page.getParams().put("expressNumber", expressNumber);
        }
        if (StringUtils.isNotBlank(createdBy)) {
            page.getParams().put("createdBy", createdBy);
        }
        if (StringUtils.isNotBlank(customer)) {
            page.getParams().put("username", customer);
        }
        if (StringUtils.isNotBlank(orderNumber)) {
            page.getParams().put("orderNumber", orderNumber);
        }
        if (StringUtils.isNotBlank(orderPayment)) {
            page.getParams().put("paymentCode", orderPayment);
        }
        if (StringUtils.isNotBlank(orderStatus)) {
            page.getParams().put("orderStatusCode", orderStatus);
        }
        if (StringUtils.isNotBlank(orderDept)) {
            page.getParams().put("deptCode", orderDept);
        }
        if (StringUtils.isNotBlank(startDate)) {
            page.getParams().put("startDate", startDate);
        }
        if (StringUtils.isNotBlank(endDate)) {
            page.getParams().put("endDate", endDate);
        }
        byte resultByte[] = orderService.exportPOrder(page);
        byte result[] = (new String(resultByte)).getBytes("utf-8");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=order.csv");
        response.setCharacterEncoding("utf-8");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(new byte[] {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF,});
        out.write(result, 0, result.length);
        out.close();
    }

    private void initQueryOrderByPage(Page<OrderEntity> page, Integer pageNo, Integer pageSize, String orderNumber,
            String orderPayment, String orderStatus, String orderDept, String expressNumber, String startDate, String endDate, String customer, String createdBy, ModelMap map) {
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        if (StringUtils.isNotBlank(expressNumber)) {
            page.getParams().put("expressNumber", expressNumber);
        }
        if (StringUtils.isNotBlank(createdBy)) {
            page.getParams().put("createdBy", createdBy);
        }
        if (StringUtils.isNotBlank(customer)) {
            page.getParams().put("username", customer);
        }
        if (StringUtils.isNotBlank(orderNumber)) {
            page.getParams().put("orderNumber", orderNumber);
        }
        if (StringUtils.isNotBlank(orderPayment)) {
            page.getParams().put("paymentCode", orderPayment);
        }
        if (StringUtils.isNotBlank(orderStatus)) {
            page.getParams().put("orderStatusCode", orderStatus);
        }
        if (StringUtils.isNotBlank(orderDept)) {
            page.getParams().put("deptCode", orderDept);
        }
        if (StringUtils.isNotBlank(startDate)) {
            page.getParams().put("startDate", startDate);
        }
        if (StringUtils.isNotBlank(endDate)) {
            page.getParams().put("endDate", endDate);
        }
        List<DeptEntity> depts = deptService.selectDeptAll();
        if (CollectionUtils.isNotEmpty(depts)) {
            map.put("depts", depts);
        }

        List<OrderStatusEntity> status = systemService.getOrderStatus();
        if (CollectionUtils.isNotEmpty(status)) {
            map.put("status", status);
        }

        List<PaymentEntity> payments = systemService.getPayments();
        if (CollectionUtils.isNotEmpty(payments)) {
            map.put("payments", payments);
        }

        map.put("expressNumber", expressNumber);
        map.put("createdBy", createdBy);
        map.put("customer", customer);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("orderNumber", orderNumber);
        map.put("orderPayment", orderPayment);
        map.put("orderStatus", orderStatus);
        map.put("orderDept", orderDept);
        map.put("page", page);
        map.put("code", HttpCode.HTTP_CODE_200);
        map.put("msg", "初始化订单列表成功");
    }

    @ResponseBody
    @RequestMapping("/remove")
    public Map<String, Object> remove(String uid, HttpServletRequest request) {
        logger.info(formatLog(request, uid));
        Map<String, Object> result = new HashMap<String, Object>();
        String msg = "操作";
        try {
            boolean value = orderService.isActive(uid, false);
            if (value) {
                value = orderPriceService.isActive(uid, false);
            }
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
