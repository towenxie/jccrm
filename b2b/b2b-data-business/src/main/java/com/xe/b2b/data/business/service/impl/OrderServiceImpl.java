package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.GoodsDao;
import com.xe.b2b.data.access.dao.MetaLocationDao;
import com.xe.b2b.data.access.dao.OrderDao;
import com.xe.b2b.data.access.dao.OrderGoodsBatchDao;
import com.xe.b2b.data.access.dao.OrderGoodsDao;
import com.xe.b2b.data.access.dao.OrderPriceDao;
import com.xe.b2b.data.access.dao.OrderStatusLogDao;
import com.xe.b2b.data.access.dao.UserDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IGoodsStockService;
import com.xe.b2b.data.business.service.IOrderService;
import com.xe.b2b.data.business.service.model.dto.GenerateModel;
import com.xe.b2b.data.common.util.DateTimeUtils;
import com.xe.b2b.data.common.util.Page;
import com.xe.b2b.data.common.util.SequenceUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import javax.annotation.Resource;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Date 2016年12月12日 下午3:32:57
 * @author Tom.Xie
 * @version v1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private IGoodsStockService goodsStockService;
    @Autowired
    private OrderPriceDao orderPriceDao;

    @Autowired
    private OrderGoodsDao orderGoodsDao;
    @Autowired
    private OrderGoodsBatchDao orderGoodsBatchDao;
    @Autowired
    private OrderStatusLogDao orderStatusLogDao;
    @Resource
    private MetaLocationDao metaLocationDao;
    @Autowired
    private ExceptionDao exceptionDao;

    @Override
    public boolean insert(OrderEntity entity) {

        boolean result = false;
        try {
            if (StringUtils.isBlank(entity.getOrderNumber())) {
                String orderNumber = SequenceUtil.getOrderNo();
                entity.setOrderNumber(orderNumber);
            }
            GenerateModel.initBaseInfo(entity);
            String fullAddress = entity.getAddress();

            MetaLocationEntity location = metaLocationDao.getLocationById(entity.getLocationId());
            if (location != null) {
                fullAddress = location.getWholeName() + "-" + fullAddress;
            }
            entity.setFullAddress(fullAddress);
            int value = orderDao.insert(entity);
            result = value != 0;
            if (result) {
                OrderStatusLogEntity log = new OrderStatusLogEntity();
                log.setOrderNumber(entity.getOrderNumber());
                log.setOrderStatusCode(entity.getOrderStatusCode());
                log.setUpdatedBy(entity.getUpdatedBy());
                value = orderStatusLogDao.insert(log);
                result = value != 0;
                if (result) {
                    Float orlTotalPrice = new Float(0);
                    List<OrderGoodsEntity> goods = entity.getGoods();
                    for (OrderGoodsEntity item : goods) {
                        GoodsEntity goodsEntity = goodsDao.selectByPrimaryKey(item.getGoodsNumber());
                        orlTotalPrice += item.getQty() * goodsEntity.getPrice();
                        item.setOrderNumber(entity.getOrderNumber());
                        item.setCreatedBy(entity.getCreatedBy());
                        item.setUpdatedBy(entity.getCreatedBy());
                        item.setCreated(entity.getCreated());
                    }
                    value = orderGoodsDao.insertList(goods);
                    result = value != 0;
                    if (result) {
                        OrderPriceEntity orderPriceEntity = new OrderPriceEntity();
                        orderPriceEntity.setCreatedBy(entity.getCreatedBy());
                        orderPriceEntity.setCreated(entity.getCreated());
                        orderPriceEntity.setUpdatedBy(entity.getUpdatedBy());
                        orderPriceEntity.setUsername(entity.getUsername());
                        orderPriceEntity.setOrderNumber(entity.getOrderNumber());
                        orderPriceEntity.setDepositPrice(entity.getDepositPrice().doubleValue());
                        orderPriceEntity.setTotalPrice(entity.getTotalPrice().doubleValue());
                        orderPriceEntity.setOrlTotalPrice(orlTotalPrice.doubleValue());
                        value = orderPriceDao.insert(orderPriceEntity);
                        result = value != 0;
                    }
                }
            }
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    @Override
    public boolean update(OrderEntity entity) {
        boolean result = false;
        try {

            if (StringUtils.isNotBlank(entity.getOrderStatusCode())) {
                OrderEntity old = orderDao.selectByPrimaryKey(entity.getOrderNumber());
                if (old.getOrderStatusCode().equals(entity.getOrderStatusCode())) {
                    return true;
                }
            } else {
                return result;
            }

            int value = orderDao.updateByPrimaryKeySelective(entity);
            result = value == 1;
            if (result) {
                OrderStatusLogEntity log = new OrderStatusLogEntity();
                log.setOrderNumber(entity.getOrderNumber());
                log.setOrderStatusCode(entity.getOrderStatusCode());
                log.setUpdatedBy(entity.getUpdatedBy());
                value = orderStatusLogDao.insert(log);

                result = value != 0;
                if ("shipped".equals(entity.getOrderStatusCode())) {
                    OrderEntity order = this.get(entity.getOrderNumber());
                    List<OrderGoodsEntity> goods = order.getGoods();
                    for (OrderGoodsEntity item : goods) {
                        item.setCreated(entity.getCreated());
                        item.setCreatedBy(entity.getCreatedBy());
                        item.setUpdatedBy(entity.getUpdatedBy());
                        goodsStockService.removeGoodsStockLog(item);
                    }
                } else if ("refunded".equals(entity.getOrderStatusCode())
                        || "rejected".equals(entity.getOrderStatusCode())) {
                    OrderEntity order = this.get(entity.getOrderNumber());
                    List<OrderGoodsEntity> goods = order.getGoods();
                    for (OrderGoodsEntity item : goods) {
                        item.setCreated(entity.getCreated());
                        item.setCreatedBy(entity.getCreatedBy());
                        item.setUpdatedBy(entity.getUpdatedBy());
                        goodsStockService.refundGoodsStockLog(item);
                    }
                }
            }
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }

        return result;
    }

    @Override
    public OrderEntity get(String key) {
        OrderEntity result = null;
        try {
            result = orderDao.selectByPrimaryKey(key);
            UserEntity user = userDao.selectByPrimaryKey(result.getCreatedBy());
            result.setUser(user);

            List<OrderGoodsEntity> goodsList = result.getGoods();
            for (OrderGoodsEntity orderGoods : goodsList) {
                GoodsEntity goods = goodsDao.selectByPrimaryKey(orderGoods.getGoodsNumber());
                orderGoods.setGoods(goods);
            }

        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    @Override
    public boolean isActive(String key, boolean isActive) {
        boolean result = false;
        try {
            OrderEntity entity = new OrderEntity();
            entity.setIsActive(isActive);
            entity.setOrderNumber(key);
            int value = orderDao.isActiveByPrimaryKey(entity);
            result = value != 0;
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    @Override
    public List<OrderEntity> queryByPage(Page<OrderEntity> page) {
        List<OrderEntity> result = null;
        int count = orderDao.countByPage(page);
        if (count == 0) {
            return Collections.emptyList();
        }
        page.setTotalRecord(count);

        try {
            result = orderDao.selectByPage(page);
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }

        return result;
    }

    public byte[] exportOrdersByUser(String createdBy) throws IOException {
        List<OrderEntity> resultList = orderDao.selectByCreatedBy(createdBy);
        String temp = new String("订单号,收件人,收货地址,收货内容,收件人电话,付款方式,付款金额,寄件人,寄件人电话\n");

        for (OrderEntity entity : resultList) {
//            List<OrderGoodsEntity> goodsList = entity.getGoods();
            String goodsContent = entity.getRemark();
//            for (OrderGoodsEntity orderGoods : goodsList) {
//                GoodsEntity goods = goodsDao.selectByPrimaryKey(orderGoods.getGoodsNumber());
//                goodsContent += goods.getName() + orderGoods.getQty() + goods.getUnit() + ";  ";
//            }
            UserEntity user = userDao.selectByPrimaryKey(entity.getCreatedBy());
            temp += entity.getOrderNumber() + "," + OrderEntity.getCsvType(entity.getUsername()) + ","
                    + OrderEntity.getCsvType(entity.getFullAddress()) + "," + OrderEntity.getCsvType(goodsContent) + ","
                    + OrderEntity.getCsvType(entity.getPhone()) + ","
                    + OrderEntity.getCsvType(entity.getPayment().getName()) + "," + entity.getTotalPrice() + "元,"
                    + OrderEntity.getCsvType(user.getUsername()) + "," + OrderEntity.getCsvType(user.getPhone()) + "\n";
        }
        byte[] result = temp.getBytes();
        return result;
    }

    @Override
    public Float getTotalPriceByPage(Page<OrderEntity> page) {
        Float result = null;
        // if (null == page.getParams().get("orderStatusCode")) {
        // page.getParams().put("orderStatusCode", "completed");
        // }

        try {
            result = orderDao.getTotalPriceByPage(page);
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }

        return result;
    }

    @Override
    public byte[] exportOrderByOrdernum(String orderNum) throws IOException {
        OrderEntity entity = orderDao.selectByPrimaryKey(orderNum);
        String temp = new String("订单号,收件人,收货地址,收货内容,收件人电话,付款方式,付款金额,寄件人,寄件人电话\n");

//        List<OrderGoodsEntity> goodsList = entity.getGoods();
        String goodsContent = entity.getRemark();
//        for (OrderGoodsEntity orderGoods : goodsList) {
//            GoodsEntity goods = goodsDao.selectByPrimaryKey(orderGoods.getGoodsNumber());
//            goodsContent += goods.getName() + orderGoods.getQty() + goods.getUnit() + ";  ";
//        }
        UserEntity user = userDao.selectByPrimaryKey(entity.getCreatedBy());
        temp += entity.getOrderNumber() + "," + OrderEntity.getCsvType(entity.getUsername()) + ","
                + OrderEntity.getCsvType(entity.getFullAddress()) + "," + OrderEntity.getCsvType(goodsContent) + ","
                + OrderEntity.getCsvType(entity.getPhone()) + ","
                + OrderEntity.getCsvType(entity.getPayment().getName()) + "," + entity.getTotalPrice() + "元,"
                + OrderEntity.getCsvType(user.getUsername()) + "," + OrderEntity.getCsvType(user.getPhone()) + "\n";
        byte[] result = temp.getBytes();

        return result;
    }

    @Override
    public byte[] exportPOrder(Page<OrderEntity> page) throws IOException {
        List<OrderEntity> orderList = this.queryByPage(page);
        String temp = new String("订单号,销售员,部门,金额,收件人,收货地址,快递单号,快递公司 ,状态,打包人,录入人,退货签收,下单时间,授权发货\n");

        for (OrderEntity entity : orderList) {
            // UserEntity user = userDao.selectByPrimaryKey(entity.getCreatedBy());
            temp += entity.getOrderNumber() + "," + OrderEntity.getCsvType(entity.getUser().getUsername()) + ","
                    + OrderEntity.getCsvType(null == entity.getDept()?"":entity.getDept().getName()) + "," + entity.getTotalPrice() + "元,"
                    + OrderEntity.getCsvType(entity.getUsername()) + ","
                    + OrderEntity.getCsvType(entity.getFullAddress()) + ","
                    + OrderEntity.getCsvType(entity.getExpressNumber()) + ","
                    + OrderEntity.getCsvType(null == entity.getExpress() ? "" : entity.getExpress().getName()) + ","
                    + OrderEntity.getCsvType(null == entity.getOrderStatus() ? "" : entity.getOrderStatus().getName()) + ","
                    + OrderEntity.getCsvType(entity.getPackageBy()) + ","
                    + OrderEntity.getCsvType(entity.getDeliverBy()) + ","
                    + OrderEntity.getCsvType(entity.getHasRund() ? "是" : "否") + ","
                    + OrderEntity
                            .getCsvType(DateTimeUtils.getStringDateTime(entity.getCreated(), "yyyy-MM-dd HH:mm:ss")) + ","
                    + OrderEntity.getCsvType("paid".equals(entity.getHasRund()) ? "待办" : "已处理") + "\n";
        }
        byte[] result = temp.getBytes();
        return result;
    }
    @Override
    public byte[] exportOrder(Page<OrderEntity> page) throws IOException {
        List<OrderEntity> orderList = this.queryByPage(page);
        String temp = new String("订单号,发货人,部门,金额,收件人,收货地址,下单时间,付款方式,定金确认,授权发货,快递单号,快递公司,状态,货款到账,退货签收,开发票\n");

        for (OrderEntity entity : orderList) {
            // UserEntity user = userDao.selectByPrimaryKey(entity.getCreatedBy());
            temp += entity.getOrderNumber() + "," + OrderEntity.getCsvType(entity.getCreatedBy()) + ","
                    + OrderEntity.getCsvType(null == entity.getDept()?"":entity.getDept().getName()) + "," + entity.getTotalPrice() + "元,"
                    + OrderEntity.getCsvType(entity.getUsername()) + ","
                    + OrderEntity.getCsvType(entity.getFullAddress()) + ","
                    + OrderEntity
                            .getCsvType(DateTimeUtils.getStringDateTime(entity.getCreated(), "yyyy-MM-dd HH:mm:ss"))
                    + "," + OrderEntity.getCsvType(null == entity.getPayment() ? "" : entity.getPayment().getName()) + ","
                    + OrderEntity.getCsvType(entity.getHasDingjin() ? "是" : "否") + ","
                    + OrderEntity.getCsvType(entity.getCanSend() ? "是" : "否") + ","
                    + OrderEntity.getCsvType(entity.getExpressNumber()) + ","
                    + OrderEntity.getCsvType(null == entity.getExpress() ? "" : entity.getExpress().getName()) + ","
                    + OrderEntity.getCsvType(null == entity.getOrderStatus() ? "" : entity.getOrderStatus().getName()) + ","
                    + OrderEntity.getCsvType(entity.getHasDaikuang() ? "是" : "否") + ","
                    + OrderEntity.getCsvType(entity.getHasRund() ? "是" : "否") + ","
                    + OrderEntity.getCsvType(entity.getHasBill() ? "是" : "否") + "\n";
        }
        byte[] result = temp.getBytes();
        return result;
    }

    @Override
    public boolean updateWithoutStatus(OrderEntity entity) {
        boolean result = false;
        try {
            int value = orderDao.updateByPrimaryKeySelective(entity);
            result = value != 0;
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

}
