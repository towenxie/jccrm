package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.GoodsStockDao;
import com.xe.b2b.data.access.dao.GoodsStockLogDao;
import com.xe.b2b.data.access.dao.StockTypeDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IGoodsStockLogService;
import com.xe.b2b.data.business.service.model.dto.GenerateModel;
import com.xe.b2b.data.common.util.Page;
import com.xe.b2b.data.common.util.SequenceUtil;

import org.apache.commons.lang3.StringUtils;
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
public class GoodsStockLogServiceImpl implements IGoodsStockLogService {
	private static final Logger logger = LogManager
			.getLogger(GoodsStockLogServiceImpl.class);
	@Autowired
	private GoodsStockLogDao goodsStockLogDao;
	@Autowired
	private GoodsStockDao goodsStockDao;
	@Autowired
	private ExceptionDao exceptionDao;
	@Autowired
	private StockTypeDao stockTypeDao;
	@Override
	public boolean insert(GoodsStockLogEntity entity) {

		boolean result = false;
		try {
			if (StringUtils.isBlank(entity.getLogNumber())) {
				String stockLogNo = SequenceUtil.getStockLogNo();
				entity.setLogNumber(stockLogNo);
			}
			GenerateModel.initBaseInfo(entity);

			int value = goodsStockLogDao.insert(entity);
			result = value != 0;
			if (result) {
				result = updateStock(entity);
			}
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

	private boolean updateStock(GoodsStockLogEntity entity) {
		boolean result = false;
		try {
			entity = goodsStockLogDao.selectByPrimaryKey(entity.getLogNumber());
			if (entity == null) {
				return result;
			}
			GoodsStockEntity stock = new GoodsStockEntity();
			stock.setUpdatedBy(entity.getUpdatedBy());
			stock.setBatchNumber(entity.getBatchNumber());
			StockTypeEntity type = entity.getStockType();
			if (type == null) {
				type = stockTypeDao.selectByPrimaryKey(entity.getStockCode());
			}
			if (type.getIsPositive()) {
				stock.setStockNum(entity.getNum());
			} else {
				stock.setStockNum(0 - entity.getNum());
			}

			int value = goodsStockDao.updateByPrimaryKeySelective(stock);
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
	public GoodsStockLogEntity get(String key) {
		GoodsStockLogEntity result = null;
		try {
			result = goodsStockLogDao.selectByPrimaryKey(key);
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
			GoodsStockLogEntity entity = new GoodsStockLogEntity();
			entity.setIsActive(isActive);
			entity.setGoodsNumber(key);
			int value = goodsStockLogDao.isActiveByPrimaryKey(entity);
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
	public List<GoodsStockLogEntity> queryByPage(Page<GoodsStockLogEntity> page) {
		List<GoodsStockLogEntity> result = null;
		int count = goodsStockLogDao.countByPage(page);
		if (count == 0) {
			return Collections.emptyList();
		}
		page.setTotalRecord(count);

		try {
			result = goodsStockLogDao.selectByPage(page);
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
	public boolean update(GoodsStockLogEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}
}
