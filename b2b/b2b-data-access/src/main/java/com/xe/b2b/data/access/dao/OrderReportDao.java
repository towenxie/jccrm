package com.xe.b2b.data.access.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xe.b2b.data.access.model.OrderReportEntity;
import com.xe.b2b.data.common.util.Page;

public interface OrderReportDao {

    
    List<OrderReportEntity> getOrderReportByDeptTeam(@Param(value = "page")Page<OrderReportEntity> page);
    
    List<OrderReportEntity> getOrderReportByDept(@Param(value = "page")Page<OrderReportEntity> page);
    
	List<OrderReportEntity> getOrderReportByParentWorkId(@Param(value = "parentCode")String parentCode, @Param(value = "page")Page<OrderReportEntity> page);
	
	List<OrderReportEntity> getOrderReportByDeptCode(@Param(value = "parentCode")String parentCode, @Param(value = "page")Page<OrderReportEntity> page);
}
