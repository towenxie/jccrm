/**
 * @ProjectName b2b-data-access
 * @FileName OrderDao.java
 * @PackageName com.xe.b2b.data.access.dao
 * @Date 2016年12月19日下午8:21:53
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.dao;

import java.util.List;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.OrderGoodsEntity;
import com.xe.b2b.data.access.model.OrderPriceEntity;

/**
 * @ClassName OrderGoodsDao
 * @Description TODO
 * @Date 2016年12月19日 下午8:21:53
 * @author Tom.Xie
 * @version v1.0
 */
public interface OrderGoodsDao extends BaseMapper<OrderGoodsEntity> {

	int insertList(List<OrderGoodsEntity> models);
	
	List<OrderGoodsEntity> selectByOrderNumber(String orderNumber);
}
