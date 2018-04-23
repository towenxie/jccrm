package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.GoodsDao;
import com.xe.b2b.data.access.dao.OrderPriceDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IOrderPriceService;
import com.xe.b2b.data.common.util.DateTimeUtils;
import com.xe.b2b.data.common.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Date 2016年12月12日 下午3:32:57
 * @author Tom.Xie
 * @version v1.0
 */
@Service
public class OrderPriceImpl implements IOrderPriceService {

    private static final Logger logger = LogManager.getLogger(OrderPriceImpl.class);
    @Autowired
    private OrderPriceDao orderPriceDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ExceptionDao exceptionDao;

    @Override
    public boolean insert(OrderPriceEntity entity) {

        boolean result = false;
        try {
            int value = orderPriceDao.insert(entity);
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
    public boolean update(OrderPriceEntity entity) {
        boolean result = false;
        try {

            int value = orderPriceDao.updateByPrimaryKeySelective(entity);
            result = value == 1;
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
    public OrderPriceEntity get(String key) {
        OrderPriceEntity result = null;
        try {
            result = orderPriceDao.selectByPrimaryKey(key);
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
            OrderPriceEntity entity = new OrderPriceEntity();
            entity.setIsActive(isActive);
            entity.setOrderNumber(key);
            int value = orderPriceDao.isActiveByPrimaryKey(entity);
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
    public List<OrderPriceEntity> queryByPage(Page<OrderPriceEntity> page) {
        List<OrderPriceEntity> result = null;
        int count = orderPriceDao.countByPage(page);
        if (count == 0) {
            return Collections.emptyList();
        }
        page.setTotalRecord(count);

        try {
            result = orderPriceDao.selectByPage(page);
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
    public byte[] exportOrder(Page<OrderPriceEntity> page) throws IOException {
        List<OrderPriceEntity> resultList = this.queryByPage(page);
        String temp = new String("订单号,客户名称,销售员,下单时间,原价总额,订单总额,预收定金,快递费,代收费%,代收手续费,实收总额,欠款总额,原因,退货明细,退货总额\n");

        for (OrderPriceEntity entity : resultList) {
            temp += entity.getOrderNumber() + "," + OrderPriceEntity.getCsvType(entity.getUsername()) + ","
                    + OrderPriceEntity.getCsvType(entity.getCreatedBy()) + ","
                    + OrderPriceEntity
                            .getCsvType(DateTimeUtils.getStringDateTime(entity.getCreated(), "yyyy-MM-dd HH:mm:ss"))
                    + "," 
                    + entity.getOrlTotalPrice() + "," + entity.getTotalPrice() + ","  + entity.getDepositPrice() + "," + entity.getSendPrice() + ","
                    + entity.getReplaceProfit() + "," + entity.getReplacePrice() + "," + entity.getRealPrice() + ","
                    + entity.getRefundPrice() + "," + OrderPriceEntity.getCsvType(entity.getReasonName()) + ","
                    + OrderPriceEntity.getCsvType(entity.getRefundDetail()) + "," + entity.getRefundPrice() + "\n";
        }
        byte[] result = temp.getBytes();
        return result;
    }
}
