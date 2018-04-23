package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.OrderReportDao;
import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.business.service.IOrderReportService;
import com.xe.b2b.data.common.util.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName OrderReportServiceImpl
 * @Description TODO
 * @Date 2016年12月12日 下午3:32:57
 * @author Tom.Xie
 * @version v1.0
 */
@Service
public class OrderReportServiceImpl implements IOrderReportService {
    private static final Logger logger = LogManager.getLogger(OrderReportServiceImpl.class);
    
    @Autowired
    private OrderReportDao orderReportDao;
    @Autowired
    private ExceptionDao exceptionDao;

	@Override
	public List<OrderReportEntity> getOrderReportByParentWorkId(
			String parentCode, Page<OrderReportEntity> page) {
		return orderReportDao.getOrderReportByParentWorkId(parentCode, page);
	}

	@Override
	public List<OrderReportEntity> getOrderReportByDeptCode(String parentCode, Page<OrderReportEntity> page) {
		return orderReportDao.getOrderReportByDeptCode(parentCode, page);
	}

    @Override
    public List<OrderReportEntity> getOrderReportByDeptTeam(Page<OrderReportEntity> page) {
        return orderReportDao.getOrderReportByDeptTeam(page);
    }

    @Override
    public List<OrderReportEntity> getOrderReportByDept(Page<OrderReportEntity> page) {
        return orderReportDao.getOrderReportByDept(page);
    }
	
}
