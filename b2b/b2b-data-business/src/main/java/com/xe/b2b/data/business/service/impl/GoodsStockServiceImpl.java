package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.GoodsStockDao;
import com.xe.b2b.data.access.dao.StockTypeDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IGoodsStockLogService;
import com.xe.b2b.data.business.service.IGoodsStockService;
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
public class GoodsStockServiceImpl implements IGoodsStockService {
	private static final Logger logger = LogManager
			.getLogger(GoodsStockServiceImpl.class);
	@Autowired
	private GoodsStockDao goodsStockDao;
	@Autowired
	private IGoodsStockLogService goodsStockLogService;

	@Autowired
	private ExceptionDao exceptionDao;

	@Override
	public boolean insert(GoodsStockEntity entity) {

		boolean result = false;
		try {
		    String stockNo = entity.getBatchNumber();
            if (StringUtils.isBlank(stockNo)) {
                stockNo = SequenceUtil.getStockNo();
                entity.setBatchNumber(stockNo);
            }

			GenerateModel.initBaseInfo(entity);
			int num = entity.getStockNum();

			entity.setStockNum(0);
			if (goodsStockDao.insert(entity) != 0) {
				GoodsStockLogEntity log = new GoodsStockLogEntity();
				log.setBatchNumber(stockNo);
				log.setGoodsNumber(entity.getGoodsNumber());
				log.setNum(num);
				log.setStockCode("add");
				log.setReason("进货，由系统生成");
				log.setCreated(entity.getCreated());
				log.setCreatedBy(entity.getCreatedBy());
				log.setUpdatedBy(entity.getUpdatedBy());
				goodsStockLogService.insert(log);
				result = true;
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

	@Override
	public boolean update(GoodsStockEntity entity) {
		boolean result = false;
		try {
			int value = goodsStockDao.updateByPrimaryKeySelective(entity);
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
	public GoodsStockEntity get(String key) {
		GoodsStockEntity result = null;
		try {
			result = goodsStockDao.selectByPrimaryKey(key);
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
			GoodsStockEntity entity = new GoodsStockEntity();
			entity.setIsActive(isActive);
			entity.setGoodsNumber(key);
			int value = goodsStockDao.isActiveByPrimaryKey(entity);
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
	public List<GoodsStockEntity> queryByPage(Page<GoodsStockEntity> page) {
		List<GoodsStockEntity> result = null;
		int count = goodsStockDao.countByPage(page);
		if (count == 0) {
			return Collections.emptyList();
		}
		page.setTotalRecord(count);

		try {
			result = goodsStockDao.selectByPage(page);
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
	public boolean removeGoodsStockLog(OrderGoodsEntity orderGoods) {
		boolean result = true;
		try {
			List<GoodsStockEntity> stockList = goodsStockDao.selectByGoodsNumber(orderGoods.getGoodsNumber());
			int total =orderGoods.getQty();
			for (GoodsStockEntity stock : stockList) {
				Integer num = stock.getStockNum();

				GoodsStockLogEntity log = new GoodsStockLogEntity();
				log.setOrderNumber(orderGoods.getOrderNumber());
				log.setBatchNumber(stock.getBatchNumber());
				log.setGoodsNumber(stock.getGoodsNumber());
				log.setStockCode("remove");
				log.setReason("出库，由系统生成");
				log.setCreated(orderGoods.getCreated());
				log.setCreatedBy(orderGoods.getCreatedBy());
				log.setUpdatedBy(orderGoods.getUpdatedBy());
				
				if (num >= total) {
					log.setNum(total);
					result = goodsStockLogService.insert(log);
					return result;
				}else {
					log.setNum(num);
					goodsStockLogService.insert(log);
					total = total - num;
				}
			}
		} catch (Exception e) {
			String level = ExceptionLevel.ERROR.toString();
			String message = e.getMessage();
			logger.error(message);
			String method = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			exceptionDao.logExceptions(new ExceptionEntity(level, method,
					message));
			result = false;
		}

		return result;
	}

	@Override
	public boolean refundGoodsStockLog(OrderGoodsEntity orderGoods) {
		boolean result = true;
		try {
			List<GoodsStockEntity> stockList = goodsStockDao.selectByGoodsNumber(orderGoods.getGoodsNumber());
			int total =orderGoods.getQty();
			for (GoodsStockEntity stock : stockList) {
				Integer num = stock.getStockNum();

				GoodsStockLogEntity log = new GoodsStockLogEntity();
				log.setOrderNumber(orderGoods.getOrderNumber());
				log.setBatchNumber(stock.getBatchNumber());
				log.setGoodsNumber(stock.getGoodsNumber());
				log.setStockCode("refund");
				log.setReason("退货，由系统生成");
				log.setCreated(orderGoods.getCreated());
				log.setCreatedBy(orderGoods.getCreatedBy());
				log.setUpdatedBy(orderGoods.getUpdatedBy());
				
				if (num >= total) {
					log.setNum(total);
					result = goodsStockLogService.insert(log);
					return result;
				}else {
					log.setNum(num);
					goodsStockLogService.insert(log);
					total = total - num;
				}
			}
		} catch (Exception e) {
			String level = ExceptionLevel.ERROR.toString();
			String message = e.getMessage();
			logger.error(message);
			String method = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			exceptionDao.logExceptions(new ExceptionEntity(level, method,
					message));
			result = false;
		}

		return result;
	}
}
