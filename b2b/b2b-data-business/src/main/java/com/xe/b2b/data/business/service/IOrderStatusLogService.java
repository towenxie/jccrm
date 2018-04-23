/**
 * @ProjectName b2b-data-business
 * @FileName IOrderService.java
 * @PackageName com.xe.b2b.data.business.service
 * @Date 2016年10月31日下午5:37:22
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service;

import java.util.List;

import com.xe.b2b.data.access.model.*;

/**
 * @ClassName IGoodsService
 * @Description 库存详情信息
 * @Date 2016年10月31日 下午5:37:22
 * @author Tom.Xie
 * @version v1.0
 */
public interface IOrderStatusLogService extends IService<OrderStatusLogEntity> {

	List<OrderStatusLogEntity> getOrderStatusLogs(String orderNumber);

	OrderStatusLogEntity getNewOrderStatusLog(String orderNumber);
}
