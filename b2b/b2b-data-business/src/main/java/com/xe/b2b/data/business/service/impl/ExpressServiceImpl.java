package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.ExpressDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IExpressService;
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
public class ExpressServiceImpl implements IExpressService {
    private static final Logger logger = LogManager.getLogger(ExpressServiceImpl.class);
    @Autowired
    private ExpressDao expressDao;
    @Autowired
    private ExceptionDao exceptionDao;
	@Override
	public boolean insert(ExpressEntity entity) {

		boolean result = false;
		try {
			GenerateModel.initBaseInfo(entity);

			int value = expressDao.insert(entity);
			result = value !=0;
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
	public boolean update(ExpressEntity entity) {
		boolean result = false;
		try {

			int value = expressDao.updateByPrimaryKeySelective(entity);
			result = value !=0;
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
	public ExpressEntity get(String key) {
		ExpressEntity result = null;
		try {
			result = expressDao.selectByPrimaryKey(key);
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
	public boolean isActive(String key, boolean isActive) {
		boolean result = false;
		try {
			ExpressEntity entity = new ExpressEntity();
			entity.setIsActive(isActive);
			entity.setCode(key);
			int value = expressDao.isActiveByPrimaryKey(entity);
			result = value != 0;
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
	public List<ExpressEntity> queryByPage(Page<ExpressEntity> page) {
		List<ExpressEntity> result = null;
		int count = expressDao.countByPage(page);
		if (count == 0) {
			return Collections.emptyList();
		}
		page.setTotalRecord(count);

		try {
			result = expressDao.selectByPage(page);
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
