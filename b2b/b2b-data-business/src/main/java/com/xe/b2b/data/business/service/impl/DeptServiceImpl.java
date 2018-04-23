package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.DeptDao;
import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IDeptService;
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
public class DeptServiceImpl implements IDeptService {
    private static final Logger logger = LogManager.getLogger(DeptServiceImpl.class);
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private ExceptionDao exceptionDao;

    @Override
    public boolean insert(DeptEntity entity) {

        boolean result = false;
        try {
            GenerateModel.initBaseInfo(entity);

            int value = deptDao.insert(entity);
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
    public boolean update(DeptEntity entity) {
        boolean result = false;
        try {

            int value = deptDao.updateByPrimaryKeySelective(entity);
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
    public DeptEntity get(String key) {
        DeptEntity result = null;
        try {
            result = deptDao.selectByPrimaryKey(key);
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
            DeptEntity entity = new DeptEntity();
            entity.setIsActive(isActive);
            entity.setCode(key);
            int value = deptDao.isActiveByPrimaryKey(entity);
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
    public List<DeptEntity> queryByPage(Page<DeptEntity> page) {
        List<DeptEntity> result = null;
        int count = deptDao.countByPage(page);
        if (count == 0) {
            return Collections.emptyList();
        }
        page.setTotalRecord(count);

        try {
            result = deptDao.selectByPage(page);
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
    public List<DeptEntity> selectDeptAll() {
        return deptDao.selectAll();
    }

    @Override
    public List<DeptEntity> selectAllParent() {
        return deptDao.selectAllParent();
    }

    @Override
    public Boolean delete(String workId) {
        boolean result = false;
        try {
            int value = deptDao.deleteByPrimaryKey(workId);
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
