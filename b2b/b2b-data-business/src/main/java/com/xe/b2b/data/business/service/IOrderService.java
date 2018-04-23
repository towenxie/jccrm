/**
 * @ProjectName b2b-data-business
 * @FileName IOrderService.java
 * @PackageName com.xe.b2b.data.business.service
 * @Date 2016年10月31日下午5:37:22
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service;

import java.io.IOException;

import com.xe.b2b.data.access.model.*;
import com.xe.b2b.data.common.util.Page;

/**
 * @ClassName IOrderService
 * @Description 订单信息
 * @Date 2016年10月31日 下午5:37:22
 * @author Tom.Xie
 * @version v1.0
 */
public interface IOrderService extends IService<OrderEntity> {

	public byte[] exportOrdersByUser(String createdBy)throws IOException;
	
	public byte[] exportOrderByOrdernum(String orderNum)throws IOException;
	
	public byte[] exportOrder(Page<OrderEntity> page)throws IOException;
    public byte[] exportPOrder(Page<OrderEntity> page)throws IOException;
	Float getTotalPriceByPage(Page<OrderEntity> page);
	
	boolean updateWithoutStatus(OrderEntity entity);
}
