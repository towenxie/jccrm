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

import com.xe.b2b.data.access.model.ExpressEntity;
import com.xe.b2b.data.access.model.OrderReasonEntity;
import com.xe.b2b.data.access.model.OrderStatusEntity;
import com.xe.b2b.data.access.model.PaymentEntity;
import com.xe.b2b.data.access.model.StockTypeEntity;

/**
 * @ClassName IDeptService
 * @Description TODO
 * @Date 2016年10月31日 下午5:37:49
 * @author Tom.Xie
 * @version v1.0
 */
public interface ISystemService {
	List<OrderStatusEntity> getOrderStatus();
	
	List<PaymentEntity> getPayments();
	
	List<ExpressEntity> getAllExpress();
	
	List<StockTypeEntity> selectAllStockType();
	
	List<OrderReasonEntity> getOrderReasons();
}
