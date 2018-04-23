package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.ExpressDao;
import com.xe.b2b.data.access.dao.OrderReasonDao;
import com.xe.b2b.data.access.dao.OrderStatusDao;
import com.xe.b2b.data.access.dao.PaymentDao;
import com.xe.b2b.data.access.dao.StockTypeDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.ISystemService;

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
public class SystemServiceImpl implements ISystemService {
    private static final Logger logger = LogManager.getLogger(SystemServiceImpl.class);
    @Autowired
    private OrderStatusDao statusDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private ExpressDao expressDao;
    @Autowired
    private OrderReasonDao orderReasonDao;
    

	@Autowired
	private StockTypeDao stockTypeDao;
    @Autowired
    private ExceptionDao exceptionDao;
	
	@Override
	public List<OrderStatusEntity> getOrderStatus() {
		List<OrderStatusEntity> result = null;
		try {
			result = statusDao.getOrderStatus();
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
	public List<PaymentEntity> getPayments() {
		List<PaymentEntity> result = null;
		try {
			result = paymentDao.getPayments();
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
	public List<ExpressEntity> getAllExpress() {
		List<ExpressEntity> result = null;
		try {
			result = expressDao.getAllExpress();
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
	public List<StockTypeEntity> selectAllStockType() {
		
		List<StockTypeEntity> result = null;
		try {
			result = stockTypeDao.selectAllStockType();
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
    public List<OrderReasonEntity> getOrderReasons() {
        List<OrderReasonEntity> result = null;
        try {
            result = orderReasonDao.getOrderReasons();
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
