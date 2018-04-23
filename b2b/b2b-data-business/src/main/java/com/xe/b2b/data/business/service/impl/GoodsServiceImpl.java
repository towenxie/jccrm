package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.GoodsDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IGoodsService;
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
public class GoodsServiceImpl implements IGoodsService {
    private static final Logger logger = LogManager.getLogger(GoodsServiceImpl.class);
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ExceptionDao exceptionDao;
	@Override
	public boolean insert(GoodsEntity entity) {

		boolean result = false;
		try {
			if (StringUtils.isBlank(entity.getGoodsNumber())) {
				String goodsNum = SequenceUtil.getGoodsNo();
				entity.setGoodsNumber(goodsNum);
			}
			GenerateModel.initBaseInfo(entity);

			int value = goodsDao.insert(entity);
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
	public boolean update(GoodsEntity entity) {
		boolean result = false;
		try {

			int value = goodsDao.updateByPrimaryKeySelective(entity);
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
	public GoodsEntity get(String key) {
		GoodsEntity result = null;
		try {
			result = goodsDao.selectByPrimaryKey(key);
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
			GoodsEntity entity = new GoodsEntity();
			entity.setIsActive(isActive);
			entity.setGoodsNumber(key);
			int value = goodsDao.isActiveByPrimaryKey(entity);
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
	public List<GoodsEntity> queryByPage(Page<GoodsEntity> page) {
		List<GoodsEntity> result = null;
		int count = goodsDao.countByPage(page);
		if (count == 0) {
			return Collections.emptyList();
		}
		page.setTotalRecord(count);

		try {
			result = goodsDao.selectByPage(page);
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
	public List<GoodsEntity> getAllGoods() {
		List<GoodsEntity> result = null;
		try {
			result = goodsDao.getAllGoods();
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
    public Boolean delete(String workId) {
        boolean result = false;
        try {
            int value = goodsDao.deleteByPrimaryKey(workId);
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
}
