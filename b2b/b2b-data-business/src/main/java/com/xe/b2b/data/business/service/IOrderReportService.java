/**
 * @ProjectName b2b-data-business
 * @FileName IUserService.java
 * @PackageName com.xe.b2b.data.business.service
 * @Date 2016年10月31日下午5:37:49
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service;

import java.util.List;

import com.xe.b2b.data.access.model.OrderReportEntity;
import com.xe.b2b.data.common.util.Page;

/**
 * @ClassName IOrderReportService
 * @Description TODO
 * @Date 2016年10月31日 下午5:37:49
 * @author Tom.Xie
 * @version v1.0
 */
public interface IOrderReportService {
    
	List<OrderReportEntity> getOrderReportByParentWorkId(String parentCode, Page<OrderReportEntity> page);
	
	List<OrderReportEntity> getOrderReportByDeptCode(String parentCode, Page<OrderReportEntity> page);
	
	List<OrderReportEntity> getOrderReportByDeptTeam(Page<OrderReportEntity> page);
	
	List<OrderReportEntity> getOrderReportByDept(Page<OrderReportEntity> page);
	
}
