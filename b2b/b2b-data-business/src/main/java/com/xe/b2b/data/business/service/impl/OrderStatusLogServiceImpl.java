package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.OrderStatusLogDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IOrderStatusLogService;
import com.xe.b2b.data.business.service.model.dto.GenerateModel;
import com.xe.b2b.data.common.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName GoodsService
 * @Description TODO
 * @Date 2016年12月12日 下午3:32:57
 * @author Tom.Xie
 * @version v1.0
 */
@Service
public class OrderStatusLogServiceImpl implements IOrderStatusLogService {
    private static final Logger logger = LogManager.getLogger(OrderStatusLogServiceImpl.class);
    @Autowired
    private OrderStatusLogDao orderStatusLogDao;
    @Autowired
    private ExceptionDao exceptionDao;
	@Override
	public boolean insert(OrderStatusLogEntity entity) {

		boolean result = false;
		try {
			GenerateModel.initBaseInfo(entity);

			int value = orderStatusLogDao.insert(entity);
			result = value == 1;
		} catch (Exception e) {
			String level = ExceptionLevel.ERROR.toString();
			String message = e.getMessage();
			logger.error(message);
			String method = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			exceptionDao.logExceptions(new ExceptionEntity(level, method,
					message));
		}
		return result;
	}
	@Override
	public boolean update(OrderStatusLogEntity entity) {
		boolean result = false;
		return result;
	}
	@Override
	public OrderStatusLogEntity get(String key) {
		OrderStatusLogEntity result = null;

		return result;
	}
	@Override
	public boolean isActive(String key, boolean isActive) {
		return false;
	}

	@Override
	public List<OrderStatusLogEntity> queryByPage(Page<OrderStatusLogEntity> page) {
		List<OrderStatusLogEntity> result = null;
		return result;
	}

	@Override
	public List<OrderStatusLogEntity> getOrderStatusLogs(String orderNumber) {
		List<OrderStatusLogEntity> result = null;
		try {
			result = orderStatusLogDao.getOrderStatusLogs(orderNumber);
		} catch (Exception e) {
			String level = ExceptionLevel.ERROR.toString();
			String message = e.getMessage();
			logger.error(message);
			String method = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			exceptionDao.logExceptions(new ExceptionEntity(level, method,
					message));
		}

		return result;
	}
	@Override
	public OrderStatusLogEntity getNewOrderStatusLog(String orderNumber) {
		OrderStatusLogEntity result = null;
		try {
			result = orderStatusLogDao.getNewOrderStatusLog(orderNumber);
		} catch (Exception e) {
			String level = ExceptionLevel.ERROR.toString();
			String message = e.getMessage();
			logger.error(message);
			String method = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			exceptionDao.logExceptions(new ExceptionEntity(level, method,
					message));
		}

		return result;
	}
}
